from rest_framework.decorators import api_view
from django.db import connection
from django.http import JsonResponse, HttpResponse
import random
import pandas as pd
from sklearn.metrics.pairwise import cosine_similarity

import warnings
warnings.filterwarnings('ignore')


def perInfo(datas):
    gender = datas[0][4].upper()
    accords = datas[0][3].split(",")
    top_list = [] if datas[0][8].split(",") == [''] else datas[0][8].split(",")
    middle_list = [] if datas[0][9].split(",") == [''] else datas[0][9].split(",")
    base_list = [] if datas[0][10].split(",") == [''] else datas[0][10].split(",")

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
    try:
        cursor = connection.cursor()
        strSql = f"""SELECT * FROM recommand.userhave WHERE perfume_id={perfume_id} and LENGTH(review) > 3 ORDER BY id DESC;"""
        cursor.execute(strSql)
        reviews = cursor.fetchall()
        datas = []
        # if reviews:
        for data in reviews:
            query = f"SELECT user.user_id FROM user WHERE id={data[2]};"
            cursor.execute(query)
            user_id = cursor.fetchall()
            row = {
                'id': data[0],
                'user_id': user_id[0][0],
                'review': data[3],
                'score': data[4],
            }
            datas.append(row)
        connection.commit()
        connection.close()
        return JsonResponse({'reviews': datas}, status = 200)
    except:
        connection.rollback()
        return HttpResponse(status = 404)


@api_view(['GET'])
def rec1(request, perfume_id):
    df = pd.read_csv('alist3.csv', encoding='utf-8')
    dfr = pd.pivot_table(df, index='perfume_id')

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


@api_view(['POST'])
def rec2(request):
    user_id = request.data.get('user_id')
    try:
        cursor = connection.cursor() 
        strSql = f"""SELECT h.perfume_id, h.score FROM userhave h JOIN user u ON u.id = h.user_id WHERE u.user_id='{user_id}'"""
        cursor.execute(strSql)
        userScore = cursor.fetchall()

        resdata = []

        dic = {}
        total = 0
        for i, v in userScore:
            strSqlp = f"SELECT recommand.perfume.accords FROM recommand.perfume WHERE recommand.perfume.perfume_id={i};"
            cursor.execute(strSqlp)
            datas = cursor.fetchall()
            accords = datas[0][0].split(",")
            for accord in accords:
                dic[accord] = dic.get(accord,0)+v
                total += 1

        for k,v in dic.items():
            dic[k] = v/total
        sdic = sorted(dic.items(), key=lambda x : x[1], reverse=True)

        strSql = f"""SELECT longevity, silage, season FROM recommand.user where user_id='{user_id}'"""
        cursor.execute(strSql)
        userInfo = cursor.fetchall()
        query = f"""SELECT perfume.perfume_id, title FROM perfume INNER JOIN onlyseason ON perfume.perfume_id = onlyseason.perfume_id where accords like '%{sdic[0][0]}%' and accords like '%{sdic[1][0]}%' and accords like '%{sdic[2][0]}%'"""
        if userInfo[0][0] != None:
            if userInfo[0][0] == 4:
                ql = " and longevity >= 3"
            else:
                ql = " and longevity <= 3"
            if userInfo[0][1] == 2:
                qs = " and sillage >= 3"
            else:
                qs = " and sillage <= 2"
            query = query+ql+qs+ f""" and season='{userInfo[0][2]}';"""
        cursor.execute(query)
        datas = cursor.fetchall()
        if len(datas) < 11:
            for i in range(len(datas)):
                perfume_info = {
                    'perfume_id': datas[i][0],
                    'title': datas[i][1],
                }
                resdata.append(perfume_info)
        else:
            out = random.sample(datas, 10)
            for i in range(10):
                perfume_info = {
                    'perfume_id': out[i][0],
                    'title': out[i][1],
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