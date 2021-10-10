from django.shortcuts import render,get_object_or_404,get_list_or_404
from rest_framework.response import Response
from rest_framework.decorators import api_view
from django.db import connection
from rest_framework import status

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
    # # res[3] : rating_score
    # # res[4] : longevity 
    # # res[5] : sillage 컬럼 이용해야함
    
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
        cursor2 = connection.cursor()
        # string으로 붙여줘야 sql 명령어에 입력이 됨 바로는 안됨
        queryString = "select * from recommand.perfume right join recommand.season on recommand.perfume.perfume_id = recommand.season.perfume_id where " +res[1]+" and "+res[3]+" and accords like '%"+res[2]+"%' and " +res[4]+" and "+res[5]+" order by "+res[0]+" desc limit 5"
        queryString2 = "select * from recommand.perfume right join recommand.season on recommand.perfume.perfume_id = recommand.season.perfume_id where accords like '%"+res[2]+"%' order by "+res[0]+" desc limit 5"

        strSql = queryString
        strSql2 = queryString2
        cursor.execute(strSql)
        cursor2.execute(strSql2)
        perfumes = cursor.fetchall()
        perfumes2 = cursor2.fetchall()
        print(perfumes)
    
        global context
        all_accords = []
        for i in range(5):
            all_accords.append(perfumes[i][3].split(','))
            all_accords.append(perfumes2[i][3].split(','))
        accord_dic = {}
        for i in all_accords:
            for j in range(len(i)):
                if i[j] not in accord_dic:
                    accord_dic[i[j]] = 1
                else:
                    accord_dic[i[j]] += 1
        sorted_dic = sorted(accord_dic.items(), key=lambda x:x[1], reverse=True)
        # print(accord_dic)
        context = {
            'perfume_id' : [perfumes[0][0],perfumes[1][0],perfumes[2][0],perfumes[3][0],perfumes[4][0]],
            'title' : [perfumes[0][1],perfumes[1][1],perfumes[2][1],perfumes[3][1],perfumes[4][1]],
            'perfume_id2' : [perfumes2[0][0],perfumes2[1][0],perfumes2[2][0],perfumes2[3][0],perfumes2[4][0]],
            'title2' : [perfumes2[0][1],perfumes2[1][1],perfumes2[2][1],perfumes2[3][1],perfumes2[4][1]],
            'accords':  accord_dic,
            'sorted_accords':  sorted_dic,
            
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
   
