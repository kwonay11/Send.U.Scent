// 테스트 메인 페이지
<template>
    <div id="DearTestMainRoot" >
         <!-- For gift, For Me 에 따라 타이틀과 버튼, 사진이 다름 -->
        <img src="@/assets/images/TestCard_2.png" alt="main1">
        
            <div class="title">Test For Dear</div>
            <div class="subtitle">상대의 성향에 맞는 향수를 추천해드립니다.<br>
            성향 테스트로 #상대에게 맞는 향수 선물하기
            
            </div>
            <div class="name">
                <input v-model="name" type="text" placeholder="받는 사람 이름 입력" autofocus style="color:white"/>
                
            </div>
            
            
            <div :disabled="!name" class="gotest" @click="gotest()">START</div>
            <p v-if="!name" style="color:white" class="mt-2">받는 사람 이름을 입력해 주세요.</p>
    </div>
</template>

<script>
export default {
     name: "DearTestMain",

    data() {
      return {
          name:'',

      }

    },
    methods: {
        gotest(){
            if (this.name != ''){

                this.$router.push({name: "DearTestQnA", query : {name: this.name}});
            }
           

        }
    }

}
</script>


<style lang="scss" scoped>
@import "@/styles/common.scss";

#DearTestMainRoot{
    background-color: $sub-color;
    background-size: 100%;

}
img{
    filter: brightness(50%);
    width:80%;
    height:40%;
    padding-bottom: 10%;


}
.title{
    text-shadow: 6px 2px 2px rgb(94, 91, 91);
    color:$heart-color;
    font-family:$eng-font-family;
    font-size:$title-font-size;
        position: absolute;
    top: 40%;
    width: 100%;

    font-weight: bold;

}
.subtitle{
    
    position: absolute;
    top: 50%;
    width: 100%;
    height: 100%;
    color:white;
    font-family:$kor-font-family;
    font-size:$subtitle-font-size;
    font-weight: bold;
    z-index: 1;
    margin-top:2vh;
    height:10vh;

}
.name{
     z-index: 100;
    position: absolute;
    top: 68%;
    right: 40%;
    height:8vh;
    padding:1vw;
    width: 20%;
    border-radius: 20px;
    border: 0.7px solid $sub-light-color;
 
    background: $dark-color;
    font-family:$kor-font-family;
    font-size:$body-font-size;

}
input::placeholder {
  color: $sub-light-color;
  font-style: italic;
}

.gotest{

    position: absolute;
    top: 78%;

    font-family:$eng-font-family;
    font-size:$subtitle-font-size;
    /* 중앙 정렬 */
    margin-top:5vh;
    right: 45%;
    text-decoration: none;
    display: block;
    background: $point-color;
    width: 150px;
    padding:0.5% 1% 0.5% 1%;
    font-weight: bold;
    border-radius:30px;
    box-shadow: 2px 2px  4px  3px rgba(97, 95, 95, 0.849);

    color:white;
}
.gotest a{
    color:white;
}
p{ 
    position: absolute;
    top: 77%;
    right:42%;

}

</style>