// 상세보기에서 지속력,잔향,계절,낮밤 하나
<template>
    <div id="SeasonIconRoot">
      <div class="icon-img">
        <img :src="require(`@/assets/icons/${this.id}.png`)" :alt="`${this.id}-image`">
      </div>
      <span class="icon-name">{{ this.id }}</span>
      <div class="statusbar">
        <div class="step" :style="`width:${this.number}%; background:${this.color};`"></div>
      </div>
    </div>
</template>

<script>
export default {
  name: "SeasonIcon",
  props: {
    id: String,
    color: String,
    number: Number,
  },
}
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";

#SeasonIconRoot {
  width: 80px;
  display: inline-block;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.icon-img {
  width: 50px;
  height: 50px;
}
.icon-img > img {
  width: 100%;
  height: 100%;
}
.icon-name {
  // font-family: $eng-font-family;
  font-size: $detail-font-size;
}
.statusbar{
  width: 80px;
  height: 7px;
  background-color:$light-color;
  border-radius: 20px;
  margin-top: 5px;
}
.statusbar .step{
  height: 7px;
  border-radius: 20px;
}
</style>