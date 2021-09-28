# from rest_framework import status
# from django.core import serializers
# from rest_framework.response import Response
from rest_framework.decorators import api_view
from django.db import connection
from django.http import JsonResponse, HttpResponse


@api_view(['GET'])
def detail(request, perfume_id):
    try:
        cursor = connection.cursor()

        strSql = f"SELECT recommand.perfume.perfume_id, title, brand, accords, gender, longevity, sillage, daynight, top, middle, base, rating_score, winter, spring, summer, autumn FROM recommand.perfume INNER JOIN recommand.season ON recommand.perfume.perfume_id = recommand.season.perfume_id WHERE recommand.perfume.perfume_id={perfume_id};"
        result = cursor.execute(strSql)
        datas = cursor.fetchall()

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
        connection.commit()
        connection.close()
        return JsonResponse(perfume_info, status = 200)

    except:
        connection.rollback()
        return HttpResponse(status = 404)



def review(request, perfume_id):
<<<<<<< HEAD
    pass
=======
    pass
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
