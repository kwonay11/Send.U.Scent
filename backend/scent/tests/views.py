from django.shortcuts import render,get_object_or_404,get_list_or_404
from rest_framework.response import Response
from rest_framework.decorators import api_view
from django.db import connection
from .serializers import TestResult
from .models import PerfumeResult

def tests(request):
    pass

@api_view(['POST'])
def tests_result(request):
    #데이터 받기
    resultString = request.data.get('resultString')
    res = []
    res.append(resultString.split('/'))
    #res[0] : season_gender_age
    #res[1] : daynight
    #res[2] : accords
    #res[3] : rating_score 컬럼 이용해야함
    
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

        # strSql = "SELECT perfume_id, title FROM perfume LIMITE 5"
        strSql = "SELECT perfume_id, title FROM perfume WHERE res[1] and res[3] LIMITE 5"
        global result
        result = cursor.execute(strSql)
        print("출력!!!!!!!!!!!!!!!!!!!!!!!",result)
        # perfumes = cursor.fetchall()

        connection.commit()
        connection.close()

    except:
        connection.rollback()
        print("Failed selecting in PerfumeView")

    # return render(request, 'book_list.html', {'books': books})
    return Response(serializers.data)

    
