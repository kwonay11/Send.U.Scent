<template>
  <div class="home">
  <MainSlider />
  <BestSlider />
  </div>
</template>

<script>
// @ is an alias to /src
import MainSlider from '@/components/Main/MainSlider.vue'
import BestSlider from '@/components/Main/BestSlider.vue'

export default {
  name: "Home",
  components: {
    MainSlider,
    BestSlider,
  
  },
};
</script>
