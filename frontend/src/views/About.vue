<template>
  <div id="about">
    <page-title pageTitle="About"/>
    <div class="subtitle" style="top:29%; position: relative;">Accords</div>
    <div style="top:30%; position: relative;">

    <video class="video" autoplay loop muted>
    <source  src="@/assets/videos/네츄럴.mp4" type="video/mp4">
    </video>
    <video class="video" autoplay loop muted>
    <source  src="@/assets/videos/플로럴.mp4" type="video/mp4">
    </video>
    <video class="video" autoplay loop muted>
    <source  src="@/assets/videos/스윗.mp4" type="video/mp4">
    </video>
    </div>
  </div>
</template>

<script>
import PageTitle from '@/components/Header/PageTitle.vue';
export default {
  name: "About",
  components: { 
      PageTitle,
  
    },
}
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";
#about{
  height:250vh;
}
.subtitle{
  font-family: $kor-font-family;
  font-size: $subtitle-font-size;
  color:$main-color;
  position: absolute;
  font-weight: bold;
 


}
.video{
 
  width: 33%;
  margin: 0 auto;

}


</style>