// 테스트 결과 페이지
<template>
    <div id="TestResultRoot">

    <div class="box">
        <h1 class="res"> 결과 : {{ $route.query.resid }}</h1>
    
    </div>

    </div>
</template>

<script>
export default {
    name:'TestResult',
    methods:{
        onSelectResult:function(result) {
            console.log("결과 받아온 값",this.result);

        },
    }

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
</style>