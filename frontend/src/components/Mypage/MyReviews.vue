<template>
  <div id="MyReivewsRoot">
    <div class="my-reviews-box">
      <p class="title">| 내가 남긴 한줄평</p>
      <div class="reviews-area mb-5">
        
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MyReivews"
}
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
* {
  font-family: $kor-font-family;
}
#MyReivewsRoot {
  width: 100%;
}
.my-reviews-box {

}
.title {
  text-align: left;
  font-size: 1.4em;
  font-weight: 700;
  color: $main-color;
}
.reviews-area {
  width: 100%;
  height: 300px;
  overflow: auto;
  border: 1px solid $gray-color;
  border-radius: 10px;
}
</style>