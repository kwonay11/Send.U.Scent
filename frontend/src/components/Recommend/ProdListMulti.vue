// ProdList 에 들어 갈 상품 하나
<template>
    <div id="ProdOneRoot">
        <div class="perfume-list">
            <div class="card-list">
                <ProdListOne v-for="(result,idx) in results" :key="idx" :result="result"/>
            </div>
        </div>
    </div>
</template>

<script>
import ProdListOne from './ProdListOne.vue'
export default {
    components: {
        ProdListOne 
    },
    props:{
        results:Array,
    },
    
}
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";
.perfume-list {
  // 상위 요소의 너비보다 하위 요소의 너비가 더 클 경우 줄바꿈
  flex-wrap: wrap;
  margin: 20px 20px 20px 25%;
  width: 100%;
  height: 100%;
  //float: left;
}
// .perfume-list .card-list .card {
//   border: 1px solid #eee;
//   border-radius: 5px;
//   height: 350px;
//   width: 250px;
//   padding: 5px;
//   margin: 20px 20px 20px 20px;
//   background-color: #e5e5e5;
//   font-family: NanumGothic;
// }
</style>