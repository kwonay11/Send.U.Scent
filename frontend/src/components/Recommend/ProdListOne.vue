// ProdList 에 들어 갈 상품 하나
<template>
    <div id="ProdOneRoot">
        <div class="card-list">
                <div class="card">
                    <img class="img"  :src="`https://fimgs.net/mdimg/perfume/375x500.${result.perfume_id}.jpg`" alt="perfume-image">
                    <p>{{result.title}}</p>
                    <p>{{result.brand}}</p>
                </div>
        </div>
            </div>
</template>

<script>
export default {
    name:"ProdListOne",
    props:{
        result: {
            type:Object,
        }
    },
}
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";

.card{
    float: left;
    width:200px;
    height: 300px;
    margin: 10px;
    padding: 10px;
}

.img{
    width:160px;
    height:220px;
}
</style>