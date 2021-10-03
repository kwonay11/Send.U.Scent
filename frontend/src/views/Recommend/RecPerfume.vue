// 전체 리스트 페이지
<template>
  <div id="RecAllRoot"> 
    <div id="ProdListViewRoot">
      <div class="title-box">
          <span>Perfume</span>     
      </div>
      <div>
        <prod-list-view/>
      </div>
      </div> 
    </div>                                            
</template>

<script>
import ProdListView from '@/components/Recommend/ProdListView.vue'

export default {
    name: "RecPerfume",
    components: {
    ProdListView,
},

}
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";

#ProdListViewRoot {
  width: 100%;
  height: 120vh;
  top: 0;
  left: 0;
  font-family: $kor-font-family;
  color: $black-color;
}
.title-box {
  width: 100%;
  height: 20%;
  top:10;
}
.filter-content {
  width: 30%;
  height: 80%;
  top: 40vh;
  background-color: #f8f4f4;  
}

</style>
