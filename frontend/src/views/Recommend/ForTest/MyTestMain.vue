// 테스트 메인 페이지
<template>
    <div id="MyTestMainRoot" >
         <!-- For gift, For Me 에 따라 타이틀과 버튼, 사진이 다름 -->
        <img src="@/assets/images/TestCard_1.png" alt="main1">
        
            <div class="title">Test For You</div>
            <div class="subtitle">당신의 성향에 맞는 향수를 추천해드립니다.<br>
            취향 테스트로 #나만의 시그니처 향기 찾기</div>
            <div class="gotest"><router-link to="/recommend/mytestQnA">START</router-link></div>
    </div>
</template>

<script>
export default {

}
</script>


<style lang="scss" scoped>
@import "@/styles/common.scss";

#MyTestMainRoot{
    background-color: $sub-color;
    background-size: 100%;

}
img{
    filter: brightness(50%);
    width:80%;
    height:40%;
    padding-bottom: 10%;


}
.title{
    text-shadow: 6px 2px 2px rgb(94, 91, 91);
    color:$heart-color;
    font-family:$eng-font-family;
    font-size:$title-font-size;
        position: absolute;
    top: 40%;
    width: 100%;

    font-weight: bold;

}
.subtitle{
    
    position: absolute;
    top: 50%;
    width: 100%;
    height: 100%;
    color:white;
    font-family:$kor-font-family;
    font-size:$subtitle-font-size;
    font-weight: bold;
    z-index: 1;
    margin-top:2vh;
    height:10vh;

}
.gotest{

    position: absolute;
    top: 65%;

    font-family:$eng-font-family;
    font-size:$subtitle-font-size;
    /* 중앙 정렬 */
    margin-top:5vh;
    right: 45%;
    text-decoration: none;
    display: block;
    background: $point-color;
    width: 150px;
    padding:0.5% 1% 0.5% 1%;
    font-weight: bold;
    border-radius:30px;
    box-shadow: 2px 2px  4px  3px rgba(97, 95, 95, 0.849);

    color:white;
}
.gotest a{
    color:white;
}

</style>