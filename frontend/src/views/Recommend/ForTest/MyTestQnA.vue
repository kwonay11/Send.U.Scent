// 테스트 문항답변 페이지
<template>
    <div id="TestQnARoot" >
      <div class="box">
        <div class="statusbar">
          <div v-if="step === 0" class="step0"></div>
          <div v-if="step === 1" class="step1"></div>
          <div v-if="step === 2" class="step2"></div>
          <div v-if="step === 3" class="step3"></div>
          <div v-if="step === 4" class="step4"></div>
          <div v-if="step === 5" class="step5"></div>
          <div v-if="step === 6" class="step6"></div>
          <div v-if="step === 7" class="step7"></div>
          
  
        </div>
        <div class="list-form" v-for="(question, index) in list"
            :key="index">
            <div class="question-box">
                <div class="question-card col-md-9"
                    v-show="index === step"
                >

                <!-- 질문 -->
                <div class="fadeIn">{{question.q}}</div>
                </div>
            </div>
            <!-- 질문 답변 -->
            <div class="answer-box" v-show="index === step">
                <div class="answer-list"
                v-for="(item, index) in question.a"
                :key="index"
                >
                
                 <button class="answer-item col-md-6 fadeIn" @click="checkAns(item.type)">{{item.answer}}</button>
                </div>
            </div>

  
        </div>
        
      </div>
  </div>
</template>

<script>
import axios from "axios"
const DJANGO_URL = process.env.VUE_APP_DJANGO_URL
import data from '@/js/MyTestQnAData.js'
export default {
    name: "MyTestQnA",

    data() {
      return {
          list: data.qnaList,
          step: 0,
          idx: 0,
          select:0,

          contents:{
            resultString: '',

          },
          // 지속성, 잔향, 계절
          longevity:'',
          sillage:'',
          season:'',


      }

    },
    methods: {
      //다음 질문 항목
        goNext(){
            this.step++;
        },
        //마지막 문항인지 체크
        checkAns(type){
          console.log("타입",type)

          this.contents.resultString += type
          if (this.step == 0){
            this.season = type
            localStorage.setItem("season", this.season)
          }
          if (this.step == 6){
            if (type == 'longevity>=4'){
              this.longevity = 4
            }
            else{  
              this.longevity = 0
              }
            localStorage.setItem("longevity", this.longevity)
          }
          if (this.step == 7){
            if (type == 'sillage>=2'){
              this.sillage = 2
            }
            else{  
              this.sillage = 0
              }
            localStorage.setItem("sillage", this.sillage)
          }
          
          // splite기준
          if (this.step ==2 || this.step == 3 || this.step == 4 || this.step == 5 || this.step == 6){
                this.contents.resultString += "/"
              }
   
          console.log("결과 스트링",this.contents.resultString)
            
            // 마지막 문항이면 결과로 넘기기
            if(this.step == 7){
               axios.post(`${DJANGO_URL}/tests/result/`,this.contents)
               .then(()=>{ 
                 console.log("백엔드에 보내기 성공")
                 this.$router.push({name: "MyTestResult"});
               })
               .catch(()=>{
                 console.log("엑시오스 실패")
               })
            }else{
              this.goNext();//인덱스 증가
            }
        },
        
        
    },
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
    width: 100%;
    height: 130vh;
}
.box{
  background-color: white;
  position: relative;
  width:80%;
  left: 9.8%;
  height: 100%;
  // padding-left: 50px;

}
.statusbar{
  z-index: 10;
    width: 41%;
    height: 2.3vh;
    top:13vh; left:22.3vw;
    position: relative;
    margin: 1.5%;
    background-color:$gray-color;
    border-radius: 20px;
    box-shadow: 1px 4px 3px 0px #00000038;



}
.statusbar .step0{
  z-index: 13;
  width: 12.5%;
  left:-0.5vw;
    height: 2.3vh;
    position: relative;
    margin: 1.5%;
    background: #f7b1a5; /* Old browsers */
background: -moz-linear-gradient(top, #f7b1a5 10%, #f19f89 37%, #ed9b87 47%, #f9a29f 63%, #f9a29f 75%, #febcc6 100%); /* FF3.6-15 */
background: -webkit-linear-gradient(top, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(to bottom, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f7b1a5', endColorstr='#febcc6',GradientType=0 );
    border-radius: 20px;

}
.statusbar .step1{
  z-index: 13;
  width: 25%;
  left:-0.5vw;
    height: 2.3vh;
    position: relative;
    margin: 1.5%;
    background: #f7b1a5; /* Old browsers */
background: -moz-linear-gradient(top, #f7b1a5 10%, #f19f89 37%, #ed9b87 47%, #f9a29f 63%, #f9a29f 75%, #febcc6 100%); /* FF3.6-15 */
background: -webkit-linear-gradient(top, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(to bottom, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f7b1a5', endColorstr='#febcc6',GradientType=0 );
    border-radius: 20px;

}
.statusbar .step2{
  z-index: 13;
  width: 37.5%;
  left:-0.5vw;
    height: 2.3vh;
    position: relative;
    margin: 1.5%;
    background: #f7b1a5; /* Old browsers */
background: -moz-linear-gradient(top, #f7b1a5 10%, #f19f89 37%, #ed9b87 47%, #f9a29f 63%, #f9a29f 75%, #febcc6 100%); /* FF3.6-15 */
background: -webkit-linear-gradient(top, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(to bottom, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f7b1a5', endColorstr='#febcc6',GradientType=0 );
    border-radius: 20px;

}
.statusbar .step3{
  z-index: 13;
  width: 50%;
  left:-0.5vw;
    height: 2.3vh;
    position: relative;
    margin: 1.5%;
    background: #f7b1a5; /* Old browsers */
background: -moz-linear-gradient(top, #f7b1a5 10%, #f19f89 37%, #ed9b87 47%, #f9a29f 63%, #f9a29f 75%, #febcc6 100%); /* FF3.6-15 */
background: -webkit-linear-gradient(top, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(to bottom, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f7b1a5', endColorstr='#febcc6',GradientType=0 );
    border-radius: 20px;

}
.statusbar .step4{
  z-index: 13;
  width: 62.5%;
  left:-0.5vw;
    height: 2.3vh;
    position: relative;
    margin: 1.5%;
    background: #f7b1a5; /* Old browsers */
background: -moz-linear-gradient(top, #f7b1a5 10%, #f19f89 37%, #ed9b87 47%, #f9a29f 63%, #f9a29f 75%, #febcc6 100%); /* FF3.6-15 */
background: -webkit-linear-gradient(top, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(to bottom, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f7b1a5', endColorstr='#febcc6',GradientType=0 );
    border-radius: 20px;

}
.statusbar .step5{
  z-index: 13;
  width: 75%;
  left:-0.5vw;
    height: 2.3vh;
    position: relative;
    margin: 1.5%;
    background: #f7b1a5; /* Old browsers */
background: -moz-linear-gradient(top, #f7b1a5 10%, #f19f89 37%, #ed9b87 47%, #f9a29f 63%, #f9a29f 75%, #febcc6 100%); /* FF3.6-15 */
background: -webkit-linear-gradient(top, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(to bottom, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f7b1a5', endColorstr='#febcc6',GradientType=0 );
    border-radius: 20px;

}
.statusbar .step6{
  z-index: 13;
  width: 87.5%;
  left:-0.5vw;
    height: 2.3vh;
    position: relative;
    margin: 1.5%;
    background: #f7b1a5; /* Old browsers */
background: -moz-linear-gradient(top, #f7b1a5 10%, #f19f89 37%, #ed9b87 47%, #f9a29f 63%, #f9a29f 75%, #febcc6 100%); /* FF3.6-15 */
background: -webkit-linear-gradient(top, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(to bottom, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f7b1a5', endColorstr='#febcc6',GradientType=0 );
    border-radius: 20px;

}
.statusbar .step7{
  z-index: 13;
  width: 101.5%;
  left:-0.5vw;
    height: 2.3vh;
    position: relative;
    margin: 1.5%;
    background: #f7b1a5; /* Old browsers */
background: -moz-linear-gradient(top, #f7b1a5 10%, #f19f89 37%, #ed9b87 47%, #f9a29f 63%, #f9a29f 75%, #febcc6 100%); /* FF3.6-15 */
background: -webkit-linear-gradient(top, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(to bottom, #f7b1a5 10%,#f19f89 37%,#ed9b87 47%,#f9a29f 63%,#f9a29f 75%,#febcc6 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f7b1a5', endColorstr='#febcc6',GradientType=0 );
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
  top:3vh;
  width:80%;
  position: relative;
  left:8vw;
  // background-color: white;
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  align-content: center;
  justify-content: center;
  align-items: center;

 
  
}
.question-box {
  width: 67%;
  
}
.question-card {
  border: 2px solid $gray-color;
  position: relative;
  top:12vh;
  padding:5%;
  border-radius: 10px;
  margin: 0 auto;
  font-size: $subtitle-font-size;
  font-weight: bold;

}
.answer-box {
  width: 100%;
  margin-top: 15vh;
   

}
.answer-item {
   border-radius: 10px;
  margin: 1.3%;
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
// 크롬은 웹킷
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
  animation-duration: 1.6s;
}
.fadeOut {
  animation: fadeOut;
  animation-duration: 1s;
}

</style>
