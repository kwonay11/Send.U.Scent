<template>
  <div id="MyinfoModifyRoot">
  <page-title pageTitle="MyPage"/>
  <modify-form />
  </div>
</template>

<script>
import PageTitle from '../../components/Header/PageTitle.vue';
import ModifyForm from '../../components/user/ModifyForm.vue';
export default {
  name: 'MyinfoModify',
  components: {
    PageTitle,
    ModifyForm,
  },
}
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
* {
  font-family: $kor-font-family;
}
#MyinfoModifyRoot {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}
</style>