//베스트 향수 슬라이드
<template>
    <div id="BestPerFumeRoot">
        <h3>BEST PERFUME</h3>
         <splide :options="options">
           <!-- for문으로 돌리면 슬라이더가 깨짐 -->
           <!-- <div v-for="(value,index) in items" v-bind:key="index">
            <splide-slide>
            <img :src="`https://fimgs.net/mdimg/perfume/375x500.${value.perfume_id}.jpg`" alt="Test">
            <p>{{value.title}}</p>
            </splide-slide>
           </div> -->
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
              <router-link :to="`/recommend/detail/55758`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.55758.jpg" alt="Test">
                <p>Velvet Rose & Oud Cologne Intense</p>
              </router-link>
            </splide-slide>
            <splide-slide>
            <router-link :to="`/recommend/detail/54108`">
             <img src="https://fimgs.net/mdimg/perfume/375x500.54108.jpg" alt="Test">
              <p>Myrrhe Carmin</p>
            </router-link>
            </splide-slide>
            <splide-slide>
              <router-link :to="`/recommend/detail/55775`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.55775.jpg" alt="Test">
                <p>Saguaro Blossom & Sand</p>
              </router-link>
            </splide-slide>
            <splide-slide>
              <router-link :to="`/recommend/detail/51935`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.51935.jpg" alt="Test">
                <p>Homme Fresh Eau de Parfum Kenzo</p>
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
        // items: [
        //   {perfume_id:5904, title: "Hesperide"},
        //   {perfume_id:13793, title: "Lys d'Eau"},
        //   {perfume_id:31236, title: "No 3"},
        //   {perfume_id:42664, title: "Midori"},
        //   {perfume_id:13754, title: "No. 5 Midnight + Swim"},
        //   {perfume_id:20971, title: "Love JLS"},
        // ]
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