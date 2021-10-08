# README

# 💝**향수 추천 프로젝트 [Send.U.Scent]**

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled.png)

[Send.U.Sccent 바로가기](https://j5c204.p.ssafy.io/)

[팀 노션 바로가기](https://www.notion.so/2C204-2074811e7e5f4be1941bb8beb4dfd17a)

[와이어프레임 바로가기](https://www.figma.com/file/nOYwQvGCuQm6wn4ViNsOC4/ssafy_bigdata)

[ERD바로가기](https://www.erdcloud.com/d/uR88eXDqtNW94szqT) ← `md` 파일 만들때 경로 수정할게요!!

[UCC 바로가기](https://www.youtube.com/watch?v=122BitBJkXI)

[기능명세, 사이트맵 바로가기](https://docs.google.com/spreadsheets/d/1LIR8_5KgDMEcU9p-PB4OfCF3BUwijQTWsk4rQ5JHxT0/edit#gid=0)

### **목차**

---

0. 팀 소개

1. 서비스 소개

2. 기술스택

3. 데이터 수집 및 추천 알고리즘

4. 아키텍처 상세

5. 레이아웃 및 디자인

---

## 0. 팀 소개(●'◡'●)

기능별로 역할을 나누었고 프론트엔드는 Vue.js ,원하는 백엔드 프레임 워크를 사용하였습니다.

- **팀장** 이태성 : 백엔드(Node.js)/프론트엔드, 공지사항, 로그인/회원가입
- 팀원 권예빈 : 백엔드(Django)/프론트엔드, 향수 테스트
- 팀원 박세영 : 백엔드(SpringBoot)/프론트엔드, 데이터가공, 향수 리스트
- 팀원 윤소영 : 백엔드(SpringBoot)/프론트엔드, 마이페이지, 로그인/회원가입
- 팀원 이연지: 백엔드(Django)/프론트엔드, 데이터가공, 향수 상세페이지, 추천알고리즘

### 🗓️구현 기간

2021.8.30 - 10.8

## **1. 서비스 소개**

> 빅데이터 기반 개인 맞춤 향수 추천 서비스
> 

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%201.png)

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%202.png)

고객이 원하는 향수를 쉽게 찾고, 자신의 취향에 맞는 향수를 추천받을 수 있도록 하여 구매에 도움을 주는 웹 서비스입니다.

### **1.1. 타겟 고객군**

- **향수에 대해 잘 모르는 사람**
    
    향에 대해 잘 몰라서 자신에게 맞는 향을 모르는 사람, 향을 직접 맡으러 오프라인 매장에 가기엔 귀찮은 고객
    
- **시향하러 가고싶은 사람**
    
    많은 향수 중에 추천을 받아 직접 시향하러 가고 싶은 사람
    
- **향수 선물을 하고 싶은 사람**
    
    받는 사람의 향수 취향을 잘 몰라서 고르기 어려운 사람
    

### **1.2. 주요 기능**

### **1.2.1. 성향테스트로 맞춤 향수 추천**

1. 8가지 질문에 대한 답을 통해 나온 결과로 3만여가지 데이터베이스에서 SQL로 SELECT하여 추출된 5가지 향수를 추천해드립니다.
- 질문 화면

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%203.png)

- 향수 추천 결과 화면

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%204.png)

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%205.png)

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%206.png)

1. 8가지 문항에 대한 결과를 가지고 추천을 한 5가지 향수와 4가지 문항으로만 추천을 한 5가지 향수 총 10가지 향수에서 Accord를 뽑아 가장 많이 누적된 횟수를 내림차순 정렬하여 보여줍니다.
    
    1.1 가장 상위 Accord 3개를 상단 제목 아래에 보여줍니다.
    
2. Accord들을 시각적으로 표현하기 위해 글자들이 원 안에 움직이도록 하여 역동적인 공처럼 구현하였습니다.
- 남을 위한 테스트

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%207.png)

향수 선물을 위한 상대를 위한 추천 테스트는  받는 사람의 이름을 입력하고 테스트 가능하도록 했습니다.

### **1.2.2. 향수 상세 정보 제공**

1. **31,987개**의 향수 정보를 확인할 수 있습니다.
향수명, 향수 사진, 브랜드, 성별, 탑 노트, 미들 노트,베이스 노트, 평점 정보를 제공합니다.
하트버튼을 클릭하면 관심목록에 추가할 수 있습니다.

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%208.png)

1. 향수의 지속력(longevity)과 잔향(sillage) 정도, 계절별 추천도와 낮/밤 추천도를 시각적으로 확인할 수 있습니다.

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%209.png)

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2010.png)

1. **코사인 유사도**를 기반으로 향수간 유사도가 높은 상위 10개의 향수를 보여줍니다.
마음에 드는 향수와 유사한 향수를 추천 받을 수 있습니다.

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2011.png)

1. 이미지로 분위기를 느낄 수 있도록 향의 핵심 조화(accord)를 표현하였습니다.

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2012.png)

1. 향의 노트들도 상위 3개씩 이미지로 나타내어 원재료를 한눈에 파악할 수 있도록 했습니다.

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2013.png)

1. 향수를 보유하고 있는 회원들의 리뷰를 보여줍니다.

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2014.png)

### **1.2.3. 사이트 보유 향수 리스트 및 필터 기능**

1. 사이트에서 제공하고 있는 향수 정보를 상위 평점 기준 1000개 우선 제시
2. 향수 이름 또는 브랜드명 검색 기능

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2015.png)

1. 계절별, 시간대별, 성별 향수 필터 기능  

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2016.png)

- 원하는 필터만을 선택적으로 체크하여 향수리스트를 조회할 수 있습니다. JPA 동적 쿼리를 사용하여 값의 유무에 따라 쿼리문을 다르게 작성하여 실행하도록 하였습니다.

### 1.2.4. 마이페이지 성향 정보 및 보유 향수/관심 목록

1. 성향 테스트 기반 선호 Accord 정보 확인
- 테스트 전과 후
    
    ![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2017.png)
    
    ![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2018.png)
    
2. 가지고 있는 목록(보유 향수) 등록 및 관리
- 검색 후 보유 향수 등록
    
    ![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2019.png)
    
- 목록에서 확인 및 삭제
    
    ![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2020.png)
    
- 보유 향수에 한해서 평점과 리뷰 등록
    
    ![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2021.png)
    
- 등록한 리뷰는 마이페이지 메인에서 확인 및 삭제 가능
    
    ![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2022.png)
    
- 보유 향수 목록을 기반으로 평가한 평점, 리뷰에 따라 가중치를 적용하여 추천 목록 갱신
    
    ![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2023.png)
    
3. 관심 목록 등록 및 관리
- 향수 상세페이지에서 등록한 관심 향수 목록 확인
    
    ![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2024.png)
    
- 목록에서 관심 등록 및 해제 관리
    
    ![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2025.png)
    
- 구매한 향수는 보유 목록으로 이동
    
    ![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2026.png)
    

## **2. 기술 스택**

## **2.0 개발 환경**
![개발환경](/uploads/3e9450b785e4972b10532087b1f71d61/개발환경.png)

### **2.1. 데이터 수집 및 처리**

> Raw 데이터를 가공해서 의미있는 자료로 만들고, 정규화하여 DB에 저장합니다.
> 
- Python 3.8.7
- Pandas
- Numpy

### **2.2. 백엔드**

- Python 3.8.7
- Django 3.2.7
    1. 라우팅, 직렬화, 테스트, 관리자 페이지 등 기능 지원이 다양하고 풍부하다.
    2. Python이다.(Python의 다양한 데이터 분석 라이브러리 사용 가능)
- DRF(Django Rest Framework)
    
    > DB의 데이터를 조회하고 유의미한 모음으로 직렬화하여, 클라이언트와 통신하는 API서버를 작성합니다.
    > 
- Swagger
- Postman
- Spring 2.5.4
- MariaDB
- Node.js v14.17.2

### **2.3. 프론트엔드**

- Vue.js
    1. 최고 점유율 라이브러리
    2. Vue 3 버전의 최신라이브러리 적용

### **2.4. 배포**

- AWS EC2
- Nginx

### **2.4. 프로젝트 관리**

- GitLab
- Notion
- Jira
- Google Sheet

## **3. 데이터 수집 및 추천 알고리즘**

### **3.1. 데이터 수집**

- Kaggle 에서 5만개의 데이터셋과 4만개의 데이터셋 2가지를 수집한 후, 값이 존재하지 않는 row를 삭제한 후, JOIN하여 향수 이름, 이미지, 브랜드, 조화(향), 탑노트, 미들노트, 베이스노트, 계절감, 시간대, 연령, 성별, 평점 컬럼으로 구성하고 값을 수정하여 31,987개의 data를 추출했습니다.

### **3.2. 추천알고리즘**

- **코사인 유사도**

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2027.png)

코사인 유사도(cosine similarity)는 내적공간의 두 벡터간 각도의 코사인값을 이용하여 측정된 벡터간의 유사한 정도를 의미합니다. 31,987개의 향수데이터를 82가지의 조화로 코사인 유사도를 측정하여 상위 10개의 item을 추천하도록 구성했습니다.

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2028.png)

- **사용자 평점 가중치 및 성향 반영**

사용자가 평가한 향수의 평점과 빈도수를 반영하여 가중치 계산을 한 후, 상위 3개 accord를 추출하여 사용자가 선호하는 지속력과 잔향, 계절감을 반영하여 해당하는 향수 전체 목록 중 랜덤으로 10개씩 추천하도록 구성했습니다.

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2029.png)

## **4. 아키텍처 상세**

- 아키텍처

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2030.png)

- ERD

![erd2.jpg](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/erd2.jpg)

## **5. 레이아웃 및 디자인**

- 와이어 프레임 (Figma)

![Untitled](README%20e9ee94eddc584bf2bf7bf31d1bf8dd2b/Untitled%2031.png)
