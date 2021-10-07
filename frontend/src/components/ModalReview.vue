<template>
  <div id="ModalReviewRoot">
    <div class="black-bg">
      <div class="modal-box p-3">
        <div class="modal-top">
          <p class="modal-title">" {{this.name}} " 향수는 어떠신가요?</p>
        </div>
        <div class="modal-middle">
          <div class="stars-group mb-3">
            <button class="score-btn score-1" @click.stop="score(1)"><img :src="setScoreImg[0]" alt="" class="score-icon"></button>
            <button class="score-btn score-2" @click.stop="score(2)"><img :src="setScoreImg[1]" alt="" class="score-icon"></button>
            <button class="score-btn score-3" @click.stop="score(3)"><img :src="setScoreImg[2]" alt="" class="score-icon"></button>
            <button class="score-btn score-4" @click.stop="score(4)"><img :src="setScoreImg[3]" alt="" class="score-icon"></button>
            <button class="score-btn score-5" @click.stop="score(5)"><img :src="setScoreImg[4]" alt="" class="score-icon"></button>
          </div>
          <div class="comment p-2">
            <textarea name="review" id="ReviewDesc" v-model="review.desc" cols="60" rows="3" placeholder="한줄평, 최대 글자 수 50자 제한" maxlength="50"></textarea>
          </div>
        </div>
        <div class="modal-bottom">
          <div class="button-group">
            <button class="cancel-btn" @click="closeBtn">취소</button>
            <button class="add-btn" :disabled="isActive" @click="addBtn">추가</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import http from '../utils/http-common.js'
import swal from 'sweetalert';
export default {
  props: [
    "id",
    "name",
  ],
  watch: {
    review: {
      deep: true,
      handler : 'checkForm'
    },
  },
  methods: {
    checkForm() {
      // 최소 3자 이상 등록 가능
      if(this.review.desc.length > 3) {
        this.isActive = false
      } else {
        this.isActive = true
      }
    },
    closeBtn() {
      this.$emit("flag", false);
    },
    addBtn() {
      const Form = {
        "id" : this.id,
        "review" : this.review.desc,
        "score" : this.review.score
      }
      http.put('/have/update', Form)
          .then((res) => {
            if(res.data.result === "success") {
              swal(this.name + " 향수의 리뷰가 등록되었습니다.")
              this.$router.go()
            } else {
              swal("등록 중 문제가 발생했습니다.")
            }
          })
          .catch(() => {
            swal("등록 중 문제가 발생했습니다.")
          })
      this.$emit("flag", false);
    },
    score(e) {
      if(e < this.review.score) {
        for(let i = 0; i < 5; i++) {
          this.setScoreImg[i] = this.offScoreImg;
        }  
      } else if(e==1 && this.review.score == 1) { // 1점에서 또 1점을 누르면
        if(!this.zeroScore) { // 0점이 아니었음
          this.zeroScore = true; // 0점으로 바꾸고
          this.review.score = 0; // 0점
          this.setScoreImg[0] = this.offScoreImg; // score 이미지 바꿈
        }
        return;
      }
      // 현재 누른 점수만큼 on 이미지 바꾸고 score 저장
      for(let i = 0; i < e; i++) {
        this.setScoreImg[i] = this.onScoreImg;
        this.zeroScore = false; // 0점이 아님
      }
      this.review.score = e;
    },
  },
  mounted() {
    this.review.perfume_id = this.id;
    this.review.perfume_name = this.name;
    for (let i = 0; i < 5; i++) {
      this.setScoreImg[i] = this.offScoreImg;
    }
  },
  data() {
    return {
      zeroScore: false,
      setScoreImg: [],
      onScoreImg : require("../assets/icons/score-on-btn.png"),
      offScoreImg : require("../assets/icons/score-off-btn.png"),
      review : {
        perfume_id: Number,
        perfume_name: String,
        score: 0,
        desc: '',
      },
      isActive: true,
    }
  },
}
</script>

<style lang="scss" scoped>
@import "../styles/common.scss";
* {
  font-family: $kor-font-family;
}
#ModalReviewRoot {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}
.black-bg {
  width: 100%;
  height: 100%;
  min-height: 1300px;
  position: relative;
  top: 0;
  left: 0;
  background-color: rgba(0,0,0,0.5);
  z-index: 10;
}
.modal-box {
  width: 600px;
  height: 300px;
  position: relative;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: white;
  border-radius: 10px;
  box-shadow: 0px 4px 20px 5px rgba(0, 0, 0, 0.25);
  z-index: 20;
  display: grid;
  align-content: stretch;
  justify-content: center;
  align-items: center;
  justify-items: center;
}
.modal-top {
  
}
.modal-top > .modal-title {
  font-size: $body-subtitle-font-size;
  font-weight: 700;
}
.modal-middle {
  width: 100%;
}
.stars-group {
  width: 35%;
  margin: 0 auto;
  display: flex;
  align-content: center;
  justify-content: space-around;
  align-items: center;
  justify-items: center;
  flex-direction: row;
  flex-wrap: nowrap;
}
.score-btn {
  width: 25px;
  height: 25px;
  background: none;
  border: none;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  align-content: center;
  justify-content: center;
  align-items: center;
}
.score-btn > .score-icon {
  width: inherit;
  height: inherit;
}
.comment {
  width: 100%;
}
#ReviewDesc {
  border: 1px solid $gray-color;
  border-radius: 5px;
  resize: none;
  width: inherit;
}
#ReviewDesc:focus {
  outline: none !important;
  border: 2px solid $point-color;
}
.modal-bottom {
  width: 90%;
}
.button-group {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  align-content: center;
  justify-content: center;
  align-items: center;
}
.cancel-btn {
	width: 23%;
	height: 35px;
	border: none;
	border-radius: 50px;
	background: $gray-color;
	margin-right: 25px;
}
.add-btn {
	width: 23%;
	height: 35px;
	border: none;
	border-radius: 50px;
	background: $point-color;
}
</style>