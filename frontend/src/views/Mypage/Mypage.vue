// 마이페이지 메인
<template>
  <div id="MypageRoot">
  </div>
  <router-view />
</template>

<script>
export default {
  name: "MyPage",
}
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
* {
  font-family: $kor-font-family;
}
#MypageRoot {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}
</style>
