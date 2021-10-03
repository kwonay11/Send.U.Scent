from rest_framework.decorators import api_view
from django.db import connection
from django.http import JsonResponse, HttpResponse
import pandas as pd
import numpy as np

from sklearn.metrics.pairwise import cosine_similarity
from sklearn.metrics import mean_squared_error

import warnings
warnings.filterwarnings('ignore')


def perInfo(datas):
    gender = datas[0][4].upper()
    accords = datas[0][3].split(",")
    top_list = datas[0][8].split(",")
    middle_list = datas[0][9].split(",")
    base_list = datas[0][10].split(",")

    perfume_info = {
        'perfume_id': datas[0][0],
        'title': datas[0][1],
        'brand': datas[0][2],
        'accords': ", ".join(accords),
        'accord_list': accords[:3],
        'gender': gender,
        'longevity': datas[0][5]*20,
        'sillage': datas[0][6]*25,
        'daynight': datas[0][7],
        'top': top_list,
        'middle': middle_list,
        'base': base_list,
        'top_list': top_list[:3],
        'middle_list': middle_list[:3],
        'base_list': base_list[:3],
        'rating_score': datas[0][11],
        'winter': datas[0][12],
        'spring': datas[0][13],
        'summer': datas[0][14],
        'autumn': datas[0][15],
    }
    return perfume_info


@api_view(['GET'])
def detail(request, perfume_id):
    try:
        cursor = connection.cursor()
        strSql = f"SELECT recommand.perfume.perfume_id, title, brand, accords, gender, longevity, sillage, daynight, top, middle, base, rating_score, winter, spring, summer, autumn FROM recommand.perfume INNER JOIN recommand.season ON recommand.perfume.perfume_id = recommand.season.perfume_id WHERE recommand.perfume.perfume_id={perfume_id};"
        cursor.execute(strSql)
        datas = cursor.fetchall()
        perfume_info = perInfo(datas)
        connection.commit()
        connection.close()
        return JsonResponse(perfume_info, status = 200)
    except:
        connection.rollback()
        return HttpResponse(status = 404)


@api_view(['GET'])
def review(request, perfume_id):
    pass


@api_view(['GET'])
def rec1(request, perfume_id):
    df = pd.read_csv('alist3.csv', encoding='utf-8')
    dfr = pd.pivot_table(df, index='perfume_id')  # perfume_id:행, accord 종류들 80개 열

    item_sim = cosine_similarity(dfr, dfr)
    item_sim_df = pd.DataFrame(data=item_sim, index=dfr.index, columns=dfr.index)

    test = item_sim_df[perfume_id].sort_values(ascending=False)[:11]
    res = test.index.tolist()
    try:
        cursor = connection.cursor()
        resdata = []
        for i in res:
            if i == perfume_id: continue
            strSql = f"SELECT recommand.perfume.perfume_id, title FROM recommand.perfume WHERE recommand.perfume.perfume_id={i};"
            cursor.execute(strSql)
            datas = cursor.fetchall()
            perfume_info = {
                'perfume_id': datas[0][0],
                'title': datas[0][1],
            }
            resdata.append(perfume_info)
        context = {
            'reccList': resdata,
        }
        connection.commit()
        connection.close()
        return JsonResponse(context, status = 200)
    except:
        connection.rollback()
        return HttpResponse(status = 404)