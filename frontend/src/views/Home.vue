<template>
  <div class="home">
  <MainSlider />
  </div>
</template>

<script>
// @ is an alias to /src
import MainSlider from '@/components/Main/MainSlider.vue'

export default {
  name: "Home",
  components: {
    MainSlider,
  
  },
};
</script>
