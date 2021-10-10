<template>
  <div id="about">
    <page-title pageTitle="About"/>
    <div class="subtitle" style="top:10%; position: relative;">31987 Perfumes, 82 Accords</div>

    <div style="top:14%; position: relative;">

    <video class="video" autoplay loop muted>
    <source  src="@/assets/videos/네츄럴.mp4" type="video/mp4">
    </video>
    <video class="video" autoplay loop muted>
    <source  src="@/assets/videos/플로럴.mp4" type="video/mp4">
    </video>
    <video class="video" autoplay loop muted>
    <source  src="@/assets/videos/스윗.mp4" type="video/mp4">
    </video>
    </div>
    <div>
      
    </div>
    <div class="subtitle" style="top:19%; position: relative;">Find Your Signature</div>
    <div class="dec1">‘가장 나다운 향’을 찾기 위한 성향 테스트를 함께합니다.</div>
    <img style="top:19%; position: relative;width:30%;margin:10px" src="@/assets/images/mytest.png" alt="mytest">
    <img style="top:19%; position: relative;width:30%;margin:10px" src="@/assets/images/deartest.png" alt="mytest">
    <div class="dec1" style="top:19%; position: relative;margin:1%">빅데이터를 이용한 성향 테스트 'Test For Me', 'Test For Dear'을 통해 <br>향기 정보와 취향을 분석하여 최적화된 향기를 추천합니다.</div>

    <div class="subtitle" style="top:25%; position: relative;">Similar recommendations</div>
    <div class="dec2">향수와 유사한 향수를 찾아줍니다.</div>
    <img style="top:25%; position: relative;width:70%;margin:10px" src="@/assets/images/detailrec.png" alt="detailrec">
    <div class="dec2" style="top:25%; position: relative;margin:1%">코사인 유사도 알고리즘을 통한<br>향수 디테일 페이지에서 유사한 향수들을 추천합니다.</div>
    
    <div class="subtitle" style="top:33%; position: relative;">Recommendations just for you</div>
    <div class="dec3" style="top:33%; position: relative;">내 정보와 유사한 향수를 찾아줍니다.</div>
    <img style="top:33%; position: relative;width:80%;margin:10px" src="@/assets/images/recmypage.png" alt="detailrec">
    <div class="dec3" style="top:33%; position: relative;margin:1%">사용자 평점 기반 가중치, 향수의 지속성, 잔향, 계절감 반영을 통해<br>마이 페이지에서 유사한 향수들을 추천합니다.</div>
    
  </div>
</template>

<script>
import PageTitle from '@/components/Header/PageTitle.vue';
export default {
  name: "About",
  components: { 
      PageTitle,
  
    },
}
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";
#about{
  height:380vh;
}
.subtitle{
  font-family: $kor-font-family;
  font-size: $subtitle-font-size;
  color:$main-color;
  position: absolute;
  font-weight: bold;
 


}
.dec1{
  font-family: $kor-font-family;
  font-size: $body-font-size;
  color:$main-color;

 top:19%; position: relative;
 margin-bottom:2vh;


}
.dec2{
  font-family: $kor-font-family;
  font-size: $body-font-size;
  color:$main-color;
  position: absolute;
 top:25%; position: relative;
 margin-bottom:2vh;


}
.dec3{
  font-family: $kor-font-family;
  font-size: $body-font-size;
  color:$main-color;
 margin-bottom:2vh;


}
.video{
 
  width: 30%;
  margin: 0 auto;

}


</style>