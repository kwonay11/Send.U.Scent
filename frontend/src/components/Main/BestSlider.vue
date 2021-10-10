//베스트 향수 슬라이드
<template>
    <div id="BestPerFumeRoot">
        <h3>BEST PERFUME</h3>
         <splide :options="options">
      
            <splide-slide>
              <router-link :to="`/recommend/detail/52110`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.52110.jpg" alt="Test">
                <p>Mon Paris Gold Attraction Edition</p>
              </router-link>
            </splide-slide>
       

            <splide-slide>
              <router-link :to="`/recommend/detail/56712`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.56712.jpg" alt="Test">
                <p>Coronandel</p>
              </router-link>
            </splide-slide>
            <splide-slide>
              <router-link :to="`/recommend/detail/11465`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.11465.jpg" alt="Test">
                <p>Caprifoglio (Honeysuckle)</p>
              </router-link>
            </splide-slide>
            <splide-slide>
              <router-link :to="`/recommend/detail/55613`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.55613.jpg" alt="Test">
                <p>Do Son Limited Edition</p>
              </router-link>
            </splide-slide>
            <splide-slide>
              <router-link :to="`/recommend/detail/276`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.276.jpg" alt="Test">
                <p>CK One</p>
              </router-link>
            </splide-slide>
            <splide-slide>
            <router-link :to="`/recommend/detail/54108`">
             <img src="https://fimgs.net/mdimg/perfume/375x500.54108.jpg" alt="Test">
              <p>Myrrhe Carmin</p>
            </router-link>
            </splide-slide>
            <splide-slide>
              <router-link :to="`/recommend/detail/42828`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.42828.jpg" alt="Test">
                <p>Sel Santal</p>
              </router-link>
            </splide-slide>
            <splide-slide>
              <router-link :to="`/recommend/detail/51935`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.51935.jpg" alt="Test">
                <p>Rose Goldea Jacky Tsai Edition</p>
              </router-link>
            </splide-slide>
            <splide-slide>
              <router-link :to="`/recommend/detail/55621`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.55621.jpg" alt="Test">
                <p>Homme Fresh Eau de Parfum Kenzo</p>
              </router-link>
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
            dots: true,
        },
        
      };
    },
    
  }
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";

#BestPerFumeRoot{
    height:100vh;
}
h3{
    font-family:$kor-font-family;
    font-size:$subtitle-font-size;
    color:#78949D;
    margin-top: 6vh;
  
    /* 밑줄 조금 떨어트리기 */
    text-decoration: underline;
    text-underline-position: under;


}
img{
    
    width: 60%;
}
p{
  font-family:$eng-font-family;
    font-size:$body-subtitle-font-size;
    color:black;

}

</style>