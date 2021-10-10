<template>
  <div id="MypageMainRoot">
    <page-title pageTitle="QnA" />
    <div class="content-box mt-5 my-3">
      <QnAListView />

      <my-reviews />
    </div>
  </div>
</template>

<script>
import PageTitle from "../../components/Header/PageTitle.vue";
import QnAListView from "../../components/QnA/QnAListView.vue";

export default {
  name: "MypageMain",
  components: {
    PageTitle,
    QnAListView,
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
