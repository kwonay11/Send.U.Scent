// 테스트 문항답변 페이지
<template>
    <div id="TestQnARoot" >
        <div class="list-form" v-for="(question, index) in list"
            :key="index">
        <div class="statusbar"></div>
            <div class="question-box">
                <div class="question-card col-md-9"
                    v-show="index === step"
                >
                <span>{{question.q}}</span>
                </div>
            </div>
            <div class="answer-box" v-show="index === step">
                <div class="answer-list"
                v-for="(item, index) in question.a"
                :key="index"
                >
                <button class="answer-item col-md-6" @click="checkAns(item.type)">{{item.answer}}</button>
                </div>
            </div>
  
        </div>
  </div>
</template>

<script>
import data from '@/js/TestQnAData.js'
export default {
    name: "TestQnA",
    data() {
      return {
          list: data.qnaList,
          endPoint : 7,
          step: 0,
          idx:0,

      }
    },
    methods: {
        goNext(){
            this.step++;
        },
        checkAns(idx){
            this.select[idx]++;
            if(this.step == endPoint){
                // this.calResult();
                console.log("마지막")
            }else{
                this.goNext();
            }
        }
    }

}
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";
*{
    font-family:$kor-font-family;
    font-size:$body-font-size;
}
#TestQnARoot{
    background-color: $sub-color;
    background-size: 100%;
}
.statusbar{
    width: 52.4%;
    height: 2.3vh;
    top:10vh;
    position: relative;
    margin: 1.5%;
    background-color:$gray-color;
    border-radius: 20px;


}
ul {
	padding: 0;
	margin: 0;
}
li {
	list-style: none;
}
input {
    border: 0;
    background: none;
}
input:focus {
    outline: none;
}
button {
    border: none;
    background: none;
}
#qnaForm {
  width: 100%;
  text-align: center;
}
.list-form {
    width:80%;
    position: relative;
    left:10vw;
    background-color: white;
  display: flex;
  flex-direction: column;
//   flex-wrap: nowrap;
//   align-content: center;
//   justify-content: center;
  align-items: center;
  
}
.question-box {
  width: 70%;
}
.question-card {
  border: 2px solid $gray-color;
  position: relative;
//   margin-bottom: 4vh;
  top:10vh;
  padding:5%;
  border-radius: 10px;
  margin: 0 auto;
  font-size: $subtitle-font-size;
  font-weight: bold;
//   display: flex;
//   flex-direction: column;
//   align-content: center;
//   align-items: center;
//   justify-content: center;
}
.answer-box {
  width: 100%;

  margin-top: 12vh;
//   display: flex;
//   flex-direction: column;
//   flex-wrap: nowrap;
//   align-content: center;
//   justify-content: center;
//   align-items: center;
}
.answer-list {
//   width: 100%;
//   display: flex;
//   flex-direction: column;
//   flex-wrap: nowrap;
//   align-content: center;
//   justify-content: center;
//   align-items: center;
}
.answer-item {
  margin: 1%;
  min-height: 70px;
//   border: 0;
  font-size: $body-font-size;
  font-weight: bold;
  background-color: $gray-color;
//   padding: 10px;
}
.answer-list > .answer-item:hover, .answer-item:focus {
  background-color:$main-color;
  color: white;
}
/* 애니메이션 */
@keyframes fadeIn {
  from { opacity: 0; }
  to { opacity: 1; }
}
@keyframes fadeOut {
  from { opacity: 1; }
  to { opacity: 0; }
}
@-webkit-keyframes fadeIn {
  from {opacity: 0;}
  to {opacity: 1;}
}
@-webkit-keyframes fadeOut {
  from {opacity: 1;}
  to {opacity: 0;}
}
.fadeIn {
  animation: fadeIn;
  animation-duration: 1s;
}
.fadeOut {
  animation: fadeOut;
  animation-duration: 1s;
}

</style>