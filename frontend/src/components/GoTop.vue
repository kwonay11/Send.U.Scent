<template>
  <div class="GoTopRoot">
    <div class="btn-box">
      <button class="top-btn" v-show="visible" @click="scrollTop">
        <i class="fas fa-angle-double-up"></i>
      </button>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    scrollTop: function () {
      window.scrollTo(0,0);
    },
    scrollListener: function (e) {
      this.visible = window.scrollY > 150
    }
  },
  mounted: function () {
    window.addEventListener('scroll', this.scrollListener)
  },
  beforeUnmount: function () {
    window.removeEventListener('scroll', this.scrollListener)
  },
  data() {
    return {
      visible: false,
    }
  },

}
</script>

<style lang="scss" scoped>
@import "../styles/common.scss";
#GoTopRoot {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}
.btn-box {
  position: fixed;
  right: 40px;
  bottom: 50px;
}
.top-btn {
  width: 30px;
  height: 30px;
  border: none;
  border-radius: 100%;
  background: $light-color;
  color: $main-color;
  box-shadow: 1px 1px 10px rgba(0,0,0,0.2);
}
</style>