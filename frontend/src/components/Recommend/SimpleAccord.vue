// 상세보기에서 Accord 이미지 하나
<template>
  <div id="SimplAccordRoot">
    <div class="accord-img">
      <!-- 일단 이미지 주소 하드코딩 -->
      <img src="@/assets/test/woody.png" alt="accord-image">
      <!-- <img :src="require(`@/assets/test/${this.accord}.png`)" :alt="`${this.accord}-image`"> -->
    </div>
  </div>
</template>

<script>
export default {
  name: "SimpleAccord",
  props: {
    accord: String,
  },
}
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";

#SimplAccordRoot {
  width: 330px;
  display: inline-block;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.accord-img {
  width: 300px;
  height: 240px;
}
.accord-img > img {
  width: 100%;
  height: 100%;
}
</style>