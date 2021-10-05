// 추천 및 내가 가진, 관심 목록에 들어갈 향수 정보 하나
<template>
    <div id="SimpleProdResRoot">
      <div class="item-img">
          <img :src="`https://fimgs.net/mdimg/perfume/375x500.${this.perfume_id}.jpg`" :alt="this.name">
      </div>
      <span class="item-brand">{{this.brand}}</span>
      <span class="item-name" @click.stop="goToDetail(this.perfume_id)">{{this.name}}</span>
    </div>
</template>

<script>
import http from '../../utils/http-common.js'
import { mapState } from 'vuex';
export default {
    props : [
        "name",
        "perfume_id",
        "brand",
    ],
    computed: {
        ...mapState(["userInfo"])
    },
    methods: {
        goToDetail(v) {
            this.$router.push(`/recommend/detail/${v}`)
        },
    },
    data() {
        return {
            likeActive: true,
        }
    },
}
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
span, p {
  font-family: $kor-font-family;
}
#SimpleProdResRoot {
    width: 100%;
    display: flex;
    flex-direction: column;
    flex-wrap: nowrap;
    align-content: center;
    justify-content: center;
    align-items: center;
}
.item-img {
    width: 110px;
    height: 130px;
    // background-color: gray;
}
.item-img > img {
    width: 100%;
    height: 100%;
}
.item-brand {
    font-size: $detail-font-size;
    font-weight: bold;
}
.item-name {
    font-size: $smallest-font-size;
}
</style>