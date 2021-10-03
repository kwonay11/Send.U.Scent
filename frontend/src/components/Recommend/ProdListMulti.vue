// ProdList 에 들어 갈 상품 하나
<template>
    <div id="ProdOneRoot">
        <div class="perfume-page">
            <div class="perfume-list"> 
                <div class="card-list">
                    <div class="card" v-for="p in paginatedData" :key="p.no">    
                        <img class="img"  :src="`https://fimgs.net/mdimg/perfume/375x500.${p.perfume_id}.jpg`" alt="perfume-image">
                        <p>{{ p.title }}</p>
                        <p>{{ p.season }}</p>                    
                    </div>
                </div>                  
            </div>                
            <div class="btn-cover">
                <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
                    이전
                    </button>
                    <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
                    <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
                        다음
                </button>
            </div>    
        </div>    
    </div>    
</template>

<script>
export default {
    data(){
        return {
            pageNum: 0
        }        
    },    
    props:{
        results:Array,
        pageSize:{
            type: Number,
            required:false,
            default: 12
        },
    },
    methods: {
    nextPage () {
        this.pageNum += 1;
    },
    prevPage () {
        this.pageNum -= 1;
    }
    },
    computed: {
        pageCount () {
        let listLeng = this.results.length,
            listSize = this.pageSize,
            page = Math.floor(listLeng / listSize);
        if (listLeng % listSize > 0) page += 1;
        
        /*
        아니면 page = Math.floor((listLeng - 1) / listSize) + 1;
        이런식으로 if 문 없이 고칠 수도 있다!
        */
        return page;
        },
        paginatedData () {
        const start = this.pageNum * this.pageSize,
                end = start + this.pageSize;
        return this.results.slice(start, end);
        }
    }        
}
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";
.perfume-list{
    width: 100%;
    height: 700px;
}
.card{
    float: left;
    width:200px;
    height: 320px;
    margin: 10px;
    padding: 10px;
}

.img{
    width:150px;
    height:220px;
    display : block ;
    margin : 0 auto ;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}

</style>