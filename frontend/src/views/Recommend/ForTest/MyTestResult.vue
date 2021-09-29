// 테스트 결과 페이지
<template>
    <div id="TestResultRoot">

    <div class="box">
        <div class="title">Send you your Scent</div>
        <div class="subtitle">000님에게 어울리는 향수는,</div>
        <div class="wordcloud">
            <!-- <vue-word-cloud :words="words">
                <vue-word-cloud
                :words="[['romance', 19], ['horror', 3], ['fantasy', 7], ['adventure', 3]]"
                :color="([, weight]) => weight > 10 ? 'DeepPink' : weight > 5 ? 'RoyalBlue' : 'Indigo'"
                font-family="Roboto"
                />
            </vue-word-cloud> -->
        </div>

   
   
        <div class="dec"> 회원님이 좋아하실 만한 향수들이에요.</div>
        <div class="perfume">
   
            <div  v-for="(value,idx) in perfume_id" v-bind:key="idx">
                <router-link to="`/recommend/detail/${value}`">
                <img class="img" :src="`https://fimgs.net/mdimg/perfume/375x500.${value}.jpg`" alt="perfume-image">
                 <div class="perfume_title">{{title[idx]}}</div>
                </router-link>
            </div>
        </div>
        <div class="dec2"> 회원님과 비슷한 취향의 다른 사용자들이 선택한 향수들이에요.</div>
        <div class="perfume2">
            <div  v-for="(value,idx) in perfume_id2" v-bind:key="idx">
                    <router-link :to="`/recommend/detail/${value}`">
                    <img class="img" :src="`https://fimgs.net/mdimg/perfume/375x500.${value}.jpg`" alt="perfume-image">
                    <p class="perfume_title">{{title2[idx]}}</p>
                    </router-link>
                    <div @click="modal()">
                        <img v-if="!setModal" src="@/assets/icons/heart-on-btn.png" alt="hert-on">
                        <img v-else src="@/assets/icons/heart-off-btn.png" alt="hert-off">
                    </div>
                        <ModalLike v-if="setModal" @flag="closeModal" :id="`${value}`" :name="`${title2[idx]}`"/>
                </div>
          
        </div>
     </div>
    </div>

    
</template>


<script>
import VueWordCloud from 'vuewordcloud';

import axios from "axios"
import ModalLike from '@/components/ModalLike.vue';
const DJANGO_URL = process.env.VUE_APP_DJANGO_URL
export default {
    name:'TestResult',
    components: {
        ModalLike,
        [VueWordCloud.name]: VueWordCloud,

     
    },
    data() {
        return{ 
            perfume_id : [],
            title : [],
            perfume_id2 : [],
            title2 : [],
            
            setModal: false,
            selectedProd: {
                id: Number,
                name: String,
            },

          
           

        }
    },
    mounted() {
    // this.genLayout();
  },
    methods:{
        
        addHave(id, name) {
            this.setModal = true;
            this.selectedProd.id = id;
            
        },
        closeModal() {
            this.setModal = false;
        },
        modal(){
            this.setModal = true;
        },
         genLayout() {
      const cloud = require('d3-cloud');
      cloud()
        .words(this.words)
        .padding(1)
        .font('Impact')
        .fontSize(function (d) {
          return d.size;
        })
        .on('end', this.end)
        .spiral('archimedean')
        .start()
        .stop();
    },
    end(words) {
      const d3 = require('d3');
      const width = 300;
      const height = 300;
      d3.select('#word-cloud')
        .append('svg')
        .attr('width', width)
        .attr('height', height)
        .style('background', 'white')
        .append('g')
        .attr('transform', 'translate(' + width / 2 + ',' + height / 2 + ')') // g를 중심에서 단어들을 그리기 때문에 g를 svg 중심으로 이동
        .selectAll('text')
        .data(words)
        .enter()
        .append('text')
        .style('font-size', (d) => {
          return d.size + 'px';
        })
        .style('font-family', 'Impact')
        .attr('text-anchor', 'middle')
        .attr('transform', (d) => {
          return 'translate(' + [d.x, d.y] + ')rotate(' + d.rotate + ')';
        })
        .text((d) => d.text);
    },
       
        },
    created(){
        axios.get(`${DJANGO_URL}/scent/tests/getresult/`)
        .then((res)=>{
            console.log(res.data.perfume_id)
            this.perfume_id = res.data.perfume_id
            this.title = res.data.title
            this.perfume_id2 = res.data.perfume_id2
            this.title2 = res.data.title2
            // this.items = res.data

            console.log(res.data)
            console.log("데이터 받아옴")
        })
        .catch(()=>{
            console.log("데이터 못받음")

        })


    },
}


</script>


<style lang="scss" scoped>
@import "@/styles/common.scss";
#TestResultRoot{
    background-color: $sub-color;
    background-size: 100%;
    width: 100%;
    height: 250vh;
}
.box{
  background-color: white;
  position: relative;
  width:80%;
  left: 9.8%;
  height: 100%;

}
.res{
    z-index: 300;
    position:absolute;
    top:20vh;
    left:10vw;
    color:rgb(9, 31, 23);
}
.title{
    color:$heart-color;
    font-family:$eng-font-family;
    font-size:$title-font-size;
    position: absolute;
    top: 7%;
    width: 100%;
    font-weight: bold;

}
.subtitle{
    
    position: absolute;
    top: 13%;
    width: 100%;
    color:black;
    font-family:$kor-font-family;
    font-size:$subtitle-font-size;
    font-weight: bold;
    z-index: 1;
    margin-top:2vh;
    height:10vh;

}
.wordcloud{
    position: absolute;
    top: 30%;
    width: 100%;
    color:black;

}
.dec{
    font-family:$kor-font-family;
    font-size:$bodytitle-font-size;
    position: absolute;
    top: 52%;
    width: 100%;
    color:black;
    font-weight: bold;
    

}
.dec2{
    font-family:$kor-font-family;
    font-size:$bodytitle-font-size;
    position: absolute;
    top: 75%;
    width: 100%;
    color:black;
    font-weight: bold;
    

}
.perfume{
     display: flex;
    position: relative;
     top: 60%;
     width: 100%;
     height:10vh;
     padding-left: 6vw;
    margin-left:1vw;
    margin-right:0.5vw;

    
    
}
.perfume2{
    display: flex;
    position: relative;
     top: 79%;
     width: 100%;
     height:10vh;
     padding-left: 6vw;
    //  float: left;
    margin-left:1vw;
    margin-right:0.5vw;
    

    
    
}
.img{
    // position: relative;
    width: 54%;
    float: left;
    margin-left:0.5vw;
    margin-right:0.5vw;
    display:block;
    margin-bottom:1vh ;
    
}

.perfume_title{
    // display: flex;
    // position: absolute;
    // float:left;
    // left:-10vw;
     width:59%;
    color:black;
    font-family:$eng-font-family;
    font-size:$detail-font-size;
 
    display:block;
   
    

    
}

</style>