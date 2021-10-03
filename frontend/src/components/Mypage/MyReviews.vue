<template>
  <div id="MyReivewsRoot">
    <div class="my-reviews-box">
      <p v-if="ctitle==='MyReviews'" class="title">| 내가 남긴 한줄평</p>
      <p v-if="ctitle==='AllReviews'" class="title">| 이 향수를 가지고 있는 회원님들의 한줄평</p>
      <div class="reviews-area mb-5">
        <div class="reviews-list" 
              v-for="(review, index) in reviewList" :key="index">
          <div class="reviews-info">
            <i class="fas fa-comment comment-icon"></i>
            <span v-if="ctitle==='MyReviews'" class="review-name-score">{{review.perfume_name}} / {{review.score}} 점 </span>
            <span v-if="ctitle==='AllReviews'" class="review-name-score">{{review.user_id}} / {{review.score}} 점 </span>
          </div>
          <div class="reviews-desc mt-1">
            <span class="review-desc">" {{review.review}} "</span>
            <button v-if="ctitle==='MyReviews'" class="delte-btn" @click="DeleteBtn(review.id)"><i class="fas fa-trash-alt"></i></button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MyReivews",
  props: {
    ctitle: String,
    reviewList: Array,
  },
  methods: {
    DeleteBtn(e) {
      alert(e + " 리뷰를 삭제합니다.");
    },
  },
  data() {
    return {
      // reviewList : [
      //   {
      //     review_id: 1,
      //     perfume_name : "perfumeName1",
      //     score : 3,
      //     desc : "향이 어쩌구 저쩌구... 최대 글자 50자 제한.. 쌍따옴표로 묶인 형태로 표시",
      //   },
      //   {
      //     review_id: 2,
      //     perfume_name : "perfumeName2",
      //     score : 4,
      //     desc : "향이 어쩌구 저쩌구... 최대 글자 50자 제한.. 쌍따옴표로 묶인 형태로 표시",
      //   },
      //   {
      //     review_id: 3,
      //     perfume_name : "perfumeName3",
      //     score : 4,
      //     desc : "향이 어쩌구 저쩌구... 최대 글자 50자 제한.. 쌍따옴표로 묶인 형태로 표시",
      //   },
      //   {
      //     review_id: 4,
      //     perfume_name : "perfumeName4",
      //     score : 4,
      //     desc : "향이 어쩌구 저쩌구... 최대 글자 50자 제한.. 쌍따옴표로 묶인 형태로 표시",
      //   },
      //   {
      //     review_id: 5,
      //     perfume_name : "perfumeName5",
      //     score : 4,
      //     desc : "향이 어쩌구 저쩌구... 최대 글자 50자 제한.. 쌍따옴표로 묶인 형태로 표시",
      //   },
      // ]
    }
  },
}
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
span, p {
  font-family: $kor-font-family;
}
#MyReivewsRoot {
  width: 100%;
}
.my-reviews-box {

}
.title {
  text-align: left;
  font-size: 1.4em;
  font-weight: 700;
  color: $main-color;
}
.reviews-area {
  width: 100%;
  height: 300px;
  overflow: auto;
  border: 1px solid $gray-color;
  border-radius: 10px;
  padding: 10px;
}
.reviews-area::-webkit-scrollbar {
  width: 7px;
}
// scrollbar 상태바
.reviews-area::-webkit-scrollbar-thumb {
  background-color: $gray-color;
  border-radius: 10px;
  border: 1px solid $light-color;
}
// scrollbar 전체바
.reviews-area::-webkit-scrollbar-track {
  background-color: $light-color;
  border-radius: 10px;
  margin: 10px;
}
.reviews-list {
  margin: 10px 20px 20px;
  text-align: left;
}
.comment-icon {
  color: $main-color;
  margin-right: 10px;
}
.review-name-score {
  font-weight: bold;
}
.reviews-desc {
  color: $dark-color;
  margin-left: 20px;
}
.delte-btn {
    border: none;
    border-radius: 5px;
    background-color: $light-color;
    font-size: 0.7em;
    margin-left: 10px;
}
.delte-btn:hover {
  background-color: $sub-point-color;
  color: $white-color;
}
</style>