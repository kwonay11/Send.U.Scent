<template>
  <div id="MypageMainRoot">
    <page-title pageTitle="Notice" />
    <div class="content-box mt-5 my-3">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import PageTitle from "../../components/Header/PageTitle.vue";

export default {
  name: "MypageMain",
  components: {
    PageTitle,
  },
};
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
* {
  font-family: $kor-font-family;
}
#MypageMainRoot {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}
.button-group {
  width: 90%;
  margin: 0 auto;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  align-content: center;
  justify-content: space-evenly;
}
</style>
