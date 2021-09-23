// 테스트 결과 페이지
<template>
    <div id="TestResultRoot">

    <div class="box">
        <div class="title">Send you your Scent</div>
        <h1 class="res"> 결과 : {{ $route.query.resid }}</h1>
        <div class="subtitle">000님에게 어울리는 향수는,</div>
        <div class="wordcloud"> 워드클라우드 이미지 자리</div>
        <div>
            
        </div>
    
    </div>

    </div>
</template>

<script>

export default {
    name:'TestResult',
    data() {
        return{ 
        

        }
    },
    methods:{
       
        },
    }


</script>


<style lang="scss" scoped>
@import "@/styles/common.scss";
*{
    font-family:$kor-font-family;
    font-size:$body-font-size;
}
#TestResultRoot{
    background-color: $sub-color;
    background-size: 100%;
    width: 100%;
    height: 100vh;
}
.box{
  background-color: white;
  position: relative;
  width:80%;
  left: 9.8%;
  height: 100%;

}
.res{
    z-index: 300;
    position:absolute;
    top:20vh;
    left:10vw;
    color:rgb(9, 31, 23);
}
.title{
    color:$heart-color;
    font-family:$eng-font-family;
    font-size:$title-font-size;
    position: absolute;
    top: 13%;
    width: 100%;
    font-weight: bold;

}
.subtitle{
    
    position: absolute;
    top: 21%;
    width: 100%;
    color:black;
    font-family:$kor-font-family;
    font-size:$subtitle-font-size;
    font-weight: bold;
    z-index: 1;
    margin-top:2vh;
    height:10vh;

}
.wordcloud{
    position: absolute;
    top: 30%;
    width: 100%;
    color:black;

}
</style>