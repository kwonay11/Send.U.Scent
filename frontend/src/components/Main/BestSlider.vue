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
              <router-link :to="`/recommend/detail/5904`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.5904.jpg" alt="Test">
                <p>Hesperide</p>
              </router-link>
            </splide-slide>
            <splide-slide>
              <router-link :to="`/recommend/detail/13793`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.13793.jpg" alt="Test">
                <p>Lys d'Eau</p>
              </router-link>
            </splide-slide>
            <splide-slide>
            <router-link :to="`/recommend/detail/31236`">
              <img src="https://fimgs.net/mdimg/perfume/375x500.31236.jpg" alt="Test">
              <p>No 3</p>
            </router-link>
            </splide-slide>
            <splide-slide>
              <router-link :to="`/recommend/detail/31236`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.42664.jpg" alt="Test">
                <p>Midori</p>
              </router-link>
            </splide-slide>
            <splide-slide>
              <router-link :to="`/recommend/detail/13754`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.13754.jpg" alt="Test">
                <p>No. 5 Midnight + Swim</p>
              </router-link>
            </splide-slide>
            <splide-slide>
              <router-link :to="`/recommend/detail/983`">
                <img src="https://fimgs.net/mdimg/perfume/375x500.983.jpg" alt="Test">
                <p>Cognac</p>
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