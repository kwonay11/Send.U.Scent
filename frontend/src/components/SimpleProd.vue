// 추천 및 내가 가진, 관심 목록에 들어갈 향수 정보 하나
<template>
    <div id="SimpleProdRoot">
        <div class="item-img">
            <img :src="`https://fimgs.net/mdimg/perfume/375x500.${this.perfume_id}.jpg`" :alt="this.name">
        </div>
        <span class="item-name">{{this.name}}</span>
    </div>
</template>

<script>
export default {
    props : [
        // "prodList",
        "id",
        "name",
        "perfume_id",
    ],
    data() {
        return {
        }
    },
    mounted() {

    },
    created() {
    }
}
</script>

<style lang="scss" scoped>
@import "../styles/common.scss";
* {
  font-family: $kor-font-family;
}
#SimpleProdRoot {
    width: 100%;
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
    width: 120px;
    height: 130px;
    background-color: gray;
}
.item-img > img {
    width: 100%;
    height: 100%;
}
.item-name {
    font-size: $body-font-size;
}
</style>