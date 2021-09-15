<template>
    <div id="mainslider">
        <splide :options="options">
        <splide-slide>

        <img src="@/assets/images/main_1.jpg" alt="main1">
        <div class="mySlides-text">
            <h1>Send me your scent.</h1>
            <h4>나를 표현하는 또 다른 방법<br>
                당신은 특별하니까,<br>
                맞춤 추천으로 조금 더 특별하게.</h4>
            <div class="gorecommend"><router-link to="/recommend">바로 보기</router-link></div>
        </div>


        </splide-slide>
        <splide-slide>
        <img src="@/assets/images/main_2.jpg" alt="main2">
        <div class="mySlides-text">
            <h1>Send me your scent.</h1>
            <h4>나를 표현하는 또 다른 방법<br>
                당신은 특별하니까,<br>
                맞춤 추천으로 조금 더 특별하게.</h4>
            <div class="gorecommend"><router-link to="/recommend"><span>바로 보기</span></router-link></div>
        </div>
        </splide-slide>
        <splide-slide>
        <img src="@/assets/images/main_3.jpg" alt="main3">
        <div class="mySlides-text">
            <h1>Send me your scent.</h1>
            <h4>나를 표현하는 또 다른 방법<br>
                당신은 특별하니까,<br>
                맞춤 추천으로 조금 더 특별하게.</h4>
            <div class="gorecommend"><router-link to="/recommend">바로 보기</router-link></div>
        </div>
        </splide-slide>
    </splide>
  

   
    </div>
  
</template>

<script>
import { Splide, SplideSlide } from '@splidejs/vue-splide';
import '@splidejs/splide/dist/css/themes/splide-default.min.css';

export default {
    name:"MainSlider",
    components: {
    Splide,
    SplideSlide,
  },
    data() {
      return {
        options: {
        type : 'fade',
        rewind      : true,
        perPage     : 1,
        autoplay    : true,
        pauseOnHover: false,
        arrows      : false,
        dots: true,
        animatedDots: true,

      
        },
      };
    },
}

</script>

<style scoped>
img{
    filter: brightness(77%);;
}
.mySlides-text{
    /* z-index: 20; */
    position: absolute;
    top: 40%;
    width: 100%;
    height: 100%;
    color:white;
    text-decoration: none;
    
}
.gorecommend {
    /* 중앙 정렬 */
    margin: 0 auto;
  font-size: 20px;
  font-weight: 100;
  text-align: center;
  text-decoration: none;
  display: block;
  background: none;
  width: 150px;
  border: 2px solid;
  margin-top:3vh;
}
.gorecommend a{
text-decoration: none;
color:white;

}

</style>

