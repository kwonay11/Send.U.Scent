// 상세보기에서 Accord 이미지 하나
<template>
  <div id="SimplAccordRoot">
    <div class="accord-img">
<<<<<<< HEAD
      <!-- 일단 이미지 주소 하드코딩 -->
      <img src="@/assets/test/woody.png" alt="accord-image">
      <!-- <img :src="require(`@/assets/test/${this.accord}.png`)" :alt="`${this.accord}-image`"> -->
=======
      <img :src="require(`@/assets/accords/${this.accord}.jpg`)" :alt="`${this.accord}-image`">
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
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