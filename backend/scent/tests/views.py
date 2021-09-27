from django.shortcuts import render,get_object_or_404,get_list_or_404
from rest_framework.response import Response
from rest_framework.decorators import api_view
from django.db import connection
from rest_framework import status
from django.http import JsonResponse,HttpResponse
import json
context ={}
def tests(request):
    pass

@api_view(['POST'])
def tests_result(request):
    #데이터 받기
    resultString = request.data.get('resultString')
    print(resultString)
            
    res=resultString.split('/')
    print(res)
    # # res[0] : season_gender_age
    # # res[1] : daynight
    # # res[2] : accords
    # # res[3] : rating_score 컬럼 이용해야함
    
    try:
        '''
        cursor(): cursor 객체 생성
        cursor 란 SQL문을 수행하고 결과를 얻는데 사용하는 객체
        cursor.execute(): 쿼리문을 연결된 DB로 보내 쿼리를 실행
        cursor.fetchall(): 쿼리 실행 결과로 반환된 전체 데이터를 데이터베이스 서버로부터 가져옴
        connection.commit(): 데이터에 대한 변경사항이 있다면 이를 확정, 갱신
        connection.close(): 데이터베이스와의 연결을 닫음
        connection.rollback(): 쿼리문 실행 도중 잘못된 경우 실행 전으로 되돌려 놓음
        '''
        cursor = connection.cursor()
        # string으로 붙여줘야 sql 명령어에 입력이 됨 바로는 안됨
        queryString = "select * from recommand.perfume right join recommand.season on recommand.perfume.perfume_id = recommand.season.perfume_id where " +res[1]+" and "+res[3]+" and accords like '%"+res[2]+"%' order by "+res[0]+" desc limit 5"

        strSql = queryString
        cursor.execute(strSql)
        perfumes = cursor.fetchall()
        # print(perfumes)
    
        global context
        context = {
            'perfume_id' : [perfumes[0][0],perfumes[1][0],perfumes[2][0],perfumes[3][0],perfumes[4][0]],
            'title' : [perfumes[0][1],perfumes[1][1],perfumes[2][1],perfumes[3][1],perfumes[4][1]]

            # 'perfume_id0' : perfumes[0][0],
            # 'title0' : perfumes[0][1],

            # 'perfume_id1' : perfumes[1][0],
            # 'title1' : perfumes[1][1],

            # 'perfume_id2' : perfumes[2][0],
            # 'title2' : perfumes[2][1],

            # 'perfume_id3' : perfumes[3][0],
            # 'title3' : perfumes[3][1],

            # 'perfume_id4' : perfumes[4][0],
            # 'title4' : perfumes[4][1],


        }

        connection.commit()
        connection.close()

    except:
        connection.rollback()
        print("Failed selecting in SQL PerfumeView")
      
    return Response(status=status.HTTP_201_CREATED)

@api_view(['GET'])
def get_result(request):
    if request.method == 'GET':
        return Response(context,status=status.HTTP_200_OK)
    # return HttpResponse(json.dumps(context), content_type = "application/json",status=status.HTTP_200_OK)

    # return HttpResponse(json.dumps(context), content_type = "application/json",status=status.HTTP_200_OK)

    
