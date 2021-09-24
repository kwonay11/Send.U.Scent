// 추천 및 내가 가진, 관심 목록에 들어갈 향수 정보 하나
<template>
    <div id="SimpleProdRoot">
        <!-- <ul class="item-list" v-for="(i, index) in this.lineLen" :key="index">
            <li class="item m-3" v-for="(item, idx) in prodList" :key="idx"> -->
        <!-- <ul class="item-list">
            <li class="item m-3"  v-for="(item, index) in prodList" :key="index">
                <div class="item-img">
                    <img src="" alt="향수 이미지">
                </div>
                <span class="item-name">{{item.name}}</span>
            </li>
        </ul> -->
        <div class="item-img">
            <img src="" alt="향수 이미지">
        </div>
        <span class="item-name">{{this.name}}</span>
    </div>
</template>

<script>
export default {
    props : [
        // "prodList",
        "id",
        "ImgUrl",
        "name",
    ],
    data() {
        return {
            // lineLen: 0,
        }
    },
    mounted() {
        // this.lineLen = this.prodList.length/5;
        // console.log(this.lineLen);
    },
}
</script>

<style lang="scss" scoped>
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
    
}
</style>