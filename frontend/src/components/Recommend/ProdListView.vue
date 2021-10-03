// 상품 리스트 + 필터
<template>
    <div>
            <div class="filter-box">
                <div class="inner-box">
                <br>   
                <div>                  
                    <form method="get" action=""> 
                        <!-- <button><img src="@/assets/icons/search.png"></button> -->
                        <input id="search-bar" type="text" placeholder="향수명 입력" v-model="pass" v-on:keyup.enter="submit"> 
                    </form>                            
                </div>  
                <br>                 
                <div id="text-line">
                <br>                     
                <label id="text-line2" >Filter</label>                       
                <br>                          
                <div class='filter'>  
                <br>                                 
                    <label id="title">|계절별</label>     
                    <br>
                    <div class="filter-check">                  
                    <input type="checkbox" id="spring" value="봄" v-model="checkedSeasons">
                    <label for="spring">봄</label>
                    <br>
                    <input type="checkbox" id="summer" value="여름" v-model="checkedSeasons">
                    <label for="summer">여름</label>
                    <br>
                    <input type="checkbox" id="autumn" value="가을" v-model="checkedSeasons">
                    <label for="autumn">가을</label>
                    <br>
                    <input type="checkbox" id="winter" value="겨울" v-model="checkedSeasons">
                    <label for="winter">겨울</label>
                    </div> 
                    <br>                
                    <!-- <span>체크한 이름: {{ checkedNames }}</span> -->
                </div> 
                <br>
                <div class='filter'>
                    <label id="title">|시간별</label> 
                    <br>              
                    <div class="filter-check">                     
                    <input type="checkbox" id="night" value="밤" v-model="checkedTimes">
                    <label for="night">밤</label>
                    <br>
                    <input type="checkbox" id="day" value="낮" v-model="checkedTimes">
                    <label for="day">낮</label>
                    </div>                      
                    <br>              
                    <!-- <span>체크한 이름: {{ checkedNames }}</span> -->
                </div>        
                <br>
                <div class='filter'>
                    <label id="title">|성별</label> 
                    <br>  
                    <div class="filter-check">             
                    <input type="checkbox" id="male" value="남성" v-model="checkedgender">
                    <label for="male">남성</label>
                    <br>
                    <input type="checkbox" id="female" value="여성" v-model="checkedgender">
                    <label for="female">여성</label>
                    </div>                    
                    <br>              
                    <!-- <span>체크한 이름: {{ checkedNames }}</span> -->
                </div>     
                </div>     
            </div> 
            </div>

            <div class="perfume-list">
                <div class="card-list">                                      
                    <div class="card">
                        <div class="img">
                        <img src="@/assets/coco.png" alt="">
                        </div>
                        <div>
                            <p>향수이름</p>
                            <p>향수 accord</p>
                            <p>향수 note</p>
                        </div> 
                    </div>
                </div>                                    
            </div>                         
    </div>           
</template>

<script>
export default {
    data(){
        return{
            checkedSeasons: []
        }
    } 

}
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";

.filter-box{
    float: left; 
    font-family: NanumGothic;    
    background-color: #f8f4f4;  
}
.filter-box .inner-box{
    margin: 20px 20px 20px 40px;
    float: left;

}
.filter-check{
    font-size: 15px;
}
#title{
    margin: 20px 0 20px 0 ;
    font-size: 20px;
}

#text-line{
    float: left;
}
#text-line2{    
    font-size: 25px;
    float: left;
}
input{
    background: white;
    box-sizing: border-box;
    border-radius: 10px;
    border: 4px solid white; 
    float: left;   
}
#search-bar{
    background: white;
    box-sizing: border-box;
    border-radius: 10px;
    border: 4px solid white;    
}
.perfume-list {
  // 상위 요소의 너비보다 하위 요소의 너비가 더 클 경우 줄바꿈
    flex-wrap: wrap;
    margin: 20px 20px 20px 25%;
    width: 100%;
    height: 100%;    
    //float: left;
}
.perfume-list .card-list .card{
    border: 1px solid #eee;
    border-radius: 5px;
    height: 350px;
    width: 250px;
    padding: 5px;
    margin: 20px 20px 20px 20px;
    background-color: #E5E5E5;
    font-family: NanumGothic;  
}


</style>