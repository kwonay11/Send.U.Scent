// 추천 및 내가 가진, 관심 목록에 들어갈 향수 정보 하나
<template>
    <div id="SimpleProdRoot">
        <div class="like-btn-group" v-if="listIs==='like'">
        <button class="like-on-btn" @click.stop="cancelLike(this.id)">
            <img src="@/assets/icons/heart-on-btn.png">
        </button>
        </div>
        <div class="item-img">
            <img :src="`https://fimgs.net/mdimg/perfume/375x500.${this.perfume_id}.jpg`" :alt="this.name">
        </div>
        <span class="item-name">{{this.name}}</span>
    </div>
</template>

<script>
import http from '../utils/http-common.js'
export default {
    props : [
        // "prodList",
        "id",
        "name",
        "perfume_id",
        "listIs",
    ],
    methods: {
        cancelLike(v) {
            alert(v + " 리스트 삭제")
            // http.
        }
    },
    data() {
        return {
        }
    },
}
</script>

<style lang="scss" scoped>
@import "../styles/common.scss";
* {
  font-family: $kor-font-family;
}
#SimpleProdRoot {
    width: 100%;
    display: flex;
    flex-direction: column;
    flex-wrap: nowrap;
    align-content: center;
    justify-content: center;
    align-items: center;
}
.item-list {
    width: 800px;
    margin: 0 auto;
}
.item {
    width: 120px;
    display: inline-block;
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
.item-name {
    font-size: $body-font-size;
}
.like-btn-group {
    position: relative;
    right: -40px;
    top: 20px;
}
.like-on-btn {
    background: none;
    border: none;
    width: 35px;
    height: 25px;
}
.like-on-btn > img {
    width: 100%;
}
</style>