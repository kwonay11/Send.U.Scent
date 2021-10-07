<template>
  <div id="MyReivewsRoot">
    <div class="my-reviews-box">
      <p v-if="ctitle==='MyReviews'" class="title">| 내가 남긴 한줄평</p>
      <p v-if="ctitle==='AllReviews'" class="title">| 이 향수를 가지고 있는 회원님들의 한줄평</p>
      <div class="reviews-area mb-5">
        <div class="reviews-list" 
              v-for="(review, index) in reviewList" :key="index">
          <div class="reviews-info" v-if="ctitle==='AllReviews'">
            <i class="fas fa-comment comment-icon"></i>
            <span class="review-name-score">{{review.user_id}} / {{review.score}} 점 </span>
          </div>
          <div class="reviews-info" v-if="ctitle==='MyReviews' && review.review !== null">
            <i class="fas fa-comment comment-icon"></i>
            <span class="review-name-score" @click="goToDetail(review.perfume_id)">{{review.title}} / {{review.score}}.0 점 </span>
          </div>
          <div v-if="ctitle==='AllReviews'" class="reviews-desc mt-1">
            <span class="review-desc">" {{review.review}} "</span>
          </div>
          <div v-if="ctitle==='MyReviews' && review.review !== null " class="reviews-desc mt-1">
            <span class="review-desc">" {{review.review}} "</span>
            <button class="delte-btn" @click="DeleteBtn(review.title, review.id)"><i class="fas fa-trash-alt"></i></button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import swal from 'sweetalert';
import http from '../../utils/http-common.js'
export default {
  name: "MyReivews",
  props: {
    ctitle: String,
    reviewList: Array,
  },
  methods: {
    DeleteBtn(e, v) {
      const review_id = v
      if(confirm(e + " 리뷰를 삭제하시겠습니까?")) {
        http.put(`/have/deleteRev/${review_id}`)
            .then((res) => {
              if(res.data.result === "success") {
                swal(e + " 향수에 대한 리뷰가 삭제되었습니다.")
                this.$router.go()
              } else {
                swal("데이터를 처리하던 중 문제가 발생했습니다.")
              }
            })
            .catch((error) => {
              console.log({...error})
            })
      }
    },
    goToDetail(v) {
      this.$router.push(`/recommend/detail/${v}`)
    },
  },
  data() {
    return {
      
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