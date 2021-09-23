//베스트 향수 슬라이드
<template>
    <div id="BestPerFumeRoot">
        <h3>BEST PERFUME</h3>
        <!-- 일단 하드코딩 -->
         <splide :options="options">
            <splide-slide>
            <img src="@/assets/images/TestCard_2.png" alt="Test">
            <p>향수 이름</p>
            </splide-slide>
            <splide-slide>
            <img src="@/assets/images/TestCard_2.png" alt="Test">
            <p>향수 이름</p>
            </splide-slide>
            <splide-slide>
            <img src="@/assets/images/TestCard_2.png" alt="Test">
            <p>향수 이름</p>
            </splide-slide>
            <splide-slide>
            <img src="@/assets/images/TestCard_2.png" alt="Test">
            <p>향수 이름</p>
            </splide-slide>
        </splide>

    </div>
</template>

<script>
import { Splide, SplideSlide } from '@splidejs/vue-splide';
import '@splidejs/splide/dist/css/themes/splide-sea-green.min.css';

export default {
    name: "BestPerFume",
    components: {
    Splide,
    SplideSlide,
  },
    data() {
      return {
        options: {
            type : 'loop',
            rewind : true,
            perPage     : 3,
            autoplay    : true,
            // arrows: true,
            dots: true,
            
            
        },
      };
    },
  }
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";

#BestPerFumeRoot{
    height:80vh;
}
h3{
    font-family:$kor-font-family;
    font-size:$subtitle-font-size;
    color:#78949D;
    margin-top: 6vh;
    margin-bottom: 6vh;
    /* 밑줄 조금 떨어트리기 */
    text-decoration: underline;
    text-underline-position: under;


}
img{
    
    width: 60%;
}

</style>