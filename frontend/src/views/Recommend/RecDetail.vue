// 상세보기 페이지
<template>
  <div id="RecDetailRoot">
    <div class="content-box">

      <div class="per-title">{{ perfumeInfo.title }}</div>

      <!-- 요약(평점,브랜드,젠더,노트) -->
      <div class="prod-content-main">
        <div class="prod-content-img">
          <img class="per-img" :src="`https://fimgs.net/mdimg/perfume/375x500.${perfumeInfo.perfume_id}.jpg`" alt="perfume-image">
          <div class="score">
            <span class="me-3">평점</span>
            <span class="score">{{ perfumeInfo.rating_score }} / 5.0</span>
          </div>
        </div>
        <div class="prod-content-desc">
          <div class="per-brand">{{ perfumeInfo.brand }}</div>
          <div class="per-gender">PREFER | {{ perfumeInfo.gender.toUpperCase() }}</div>
          
          <div class="per-note-div">
            <h3>탑 노트&nbsp;&nbsp;<span>5-10 MIN</span></h3>
            향수의 첫 인상을 결정짓는 향
            <ul>
              <span class="me-2" v-for="(item, idx) in perfumeInfo.top" :key="`t-${idx}`">
                #{{ item }}
              </span>
            </ul>
          </div>
          <div class="per-note-div">
            <h3>미들 노트&nbsp;&nbsp;<span>15-60 MIN</span></h3>
            향수 본연의 향
            <ul>
              <span class="me-2" v-for="(item, idx) in perfumeInfo.middle" :key="`m-${idx}`">
                #{{ item }}
              </span>
            </ul>
          </div>
          <div class="per-note-div">
            <h3>베이스 노트&nbsp;&nbsp;<span>2 HOURS -</span></h3>
            가장 마지막에 남는 잔향
            <ul>
              <span class="me-2" v-for="(item, idx) in perfumeInfo.base" :key="`b-${idx}`">
                #{{ item }}
              </span>
            </ul>
          </div>
        </div>
      </div>



    </div>
  </div>
</template>

<script>
export default {
  name: "RecDetail",
  data() {
    return {
      // 일단 하드코딩
      perfumeInfo: {
        // perfume_id: this.$route.params.id,
        perfume_id: 11588,
        title: "Miss Dior Cherie Eau de Parfum",
        brand: "Christian Dior",
        accords: "fruity,patchouli,woody,earthy,sweet,citrus",
        gender: "women,men",
        longevity: 4,
        sillage: 2,
        daynight:	1,
        top: "strawberry",
        middle: "jasmine,rose",
        base: "vetiver,sandalwood,patchouli,oak moss,amber",
        rating_score: 4.3,
        winter: 22,
        spring: 84,
        summer: 48,
        autumn: 27,
      },
    }
  },
}
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";

#RecDetailRoot {
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  font-family: $kor-font-family;
  color: $black-color;
}
.content-box {
  top: 0;
  padding-top: 120px;
}
.prod-content-main {
  display: flex;
  justify-content: center;
  margin-bottom: 80px;
}
.prod-content-img {
  width: 310px;
  margin-right: 10%;
}
.prod-content-desc {
  text-align: left;
  width: 300px;
}
.per-title {
  font-family: $eng-font-family;
  font-weight: bold;
  font-size: 38px;
}
.per-img {
  width: 300px;
  height: 400px;
}
.per-brand {
  font-weight: bold;
  font-size: $bodytitle-font-size;
  color: $point-color;
  margin-top: 28px;
}
.per-gender {
  font-weight: bold;
  font-size: $body-font-size;
  margin-top: 26px;
}
.per-note-div {
  margin-top: 28px;
  line-height: 1.25rem;
}
.per-note-div h3 {
  font-weight: bold;
  font-size: $body-subtitle-font-size;
}
.per-note-div h3> span {
  font-size: $smallest-font-size;
}
.per-note-div ul span {
  font-weight: bold;
  // color: $main-color;
  color: #528596;
}
.score {
  display: flex;
  justify-content: center;
  align-items: flex-end;
  margin-top: 10px;
  font-size: $body-font-size;
}
.score > span:first-child{
  font-weight: bold;
  font-size: $body-subtitle-font-size;
  color: $main-color;
}

</style>