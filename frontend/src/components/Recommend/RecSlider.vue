//추천 향수 슬라이드
<template>
  <div id="RecPerFumeRoot">
    <h3 v-if="ctitle==='recDetail'">이 향수와 가장 유사한 다른 향수들</h3>
    <h3 v-if="ctitle==='haveList'">회원님이 평가한 향수를 바탕으로 추천해드려요</h3>
    <splide :options="options">
      <splide-slide v-for="(item,idx) in reccList" v-bind:key="idx">
        <div @click="goDetail(item.perfume_id)" style="cursor: pointer;">
          <img :src="`https://fimgs.net/mdimg/perfume/375x500.${item.perfume_id}.jpg`" alt="perfume-image">
          <p>{{item.title}}</p>
        </div>
      </splide-slide>
    </splide>
  </div>
</template>

<script>
import { Splide, SplideSlide } from '@splidejs/vue-splide';
import '@splidejs/splide/dist/css/themes/splide-sea-green.min.css';

export default {
  name: "RecSilder",
  props: {
    ctitle: String,
    reccList: Array,
  },
  components: {
  Splide,
  SplideSlide,
},
  data() {
    return {
      options: {
        type : 'loop',
        rewind : true,
        perPage : 5,
        autoplay : true,
        dots: true,
      },
    };
  },
  methods: {
    goDetail(id) {
      this.$router.push({ name: 'RecDetail', params: {id: id}})
    },
  },
}
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";

h3{
  font-family:$kor-font-family;
  font-size:$bodytitle-font-size;
  color:$black-color;
  margin-top: 6vh;
  font-weight: bold;
}
.splide {
  padding-bottom: 1rem;
}
img{
  width: 40%;
}
p{
  font-family:$eng-font-family;
  font-size:$body-font-size;
  color:black;
}
</style>