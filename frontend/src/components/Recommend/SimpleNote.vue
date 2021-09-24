// 상세보기에서 Note 이미지 하나
<template>
  <div id="SimplNoteRoot">
    <div class="note-img">
      <!-- 일단 이미지 주소 하드코딩 -->
      <img src="@/assets/test/jasmine.png" alt="note-image">
      <!-- <img :src="require(`@/assets/test/${note}.png`)" alt="note-image"> -->
    </div>
  </div>
</template>

<script>
export default {
  name: "SimpleNote",
  props: {
    note: String,
  },
}
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";

#SimplNoteRoot {
  width: 190px;
  display: inline-block;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.note-img {
  width: 160px;
  height: 150px;
}
.note-img > img {
  width: 100%;
  height: 100%;
}
</style>