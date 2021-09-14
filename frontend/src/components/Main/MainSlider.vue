<template>
    <div id="mainslider">
        <splide :options="options">
        <splide-slide>
        <img src="@/assets/images/main_1.jpg" alt="main1">
        </splide-slide>
        <splide-slide>
        <img src="@/assets/images/main_2.jpg" alt="main2">
        </splide-slide>
        <splide-slide>
        <img src="@/assets/images/main_3.jpg" alt="main3">
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

