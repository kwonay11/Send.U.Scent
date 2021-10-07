// 가지고 있는 향수 검색 및 추가 페이지
<template>
  <div id="HaveAddRoot">
    <page-title pageTitle="I have" />
    <div class="content-box mt-5 my-3">
      <p class="body-title mt-2">어떤 향수를 가지고 있나요?</p>
      <div class="search-content-box mt-5">
        <div class="search-box">
          <input type="text" class="search-input" v-model="this.searchText" placeholder="이름 또는 브랜드명으로 검색" 
                @keyup.enter="this.getSearchList()">
          <button class="search-btn" @click="getSearchList()"><i class="fas fa-search"></i></button>
        </div>
        <div class="search-res-list mt-3">
          <ui v-if="loadActive" class="loading">
            <li>
              <div class="spinner-border text-info"></div>
            </li>
          </ui>
          <ul v-if="!error && !loadActive" class="item-list">
            <li class="item m-3"  v-for="(item, index) in searchList" :key="index">
              <Prod :name="item.title" :perfume_id="item.perfume_id" :brand="item.brand" @click="addHave(item.perfume_id, item.title)"/>
            </li>
          </ul>
          <ul v-if="error">
            <li class="error mt-5">
              <b>이런.. 검색 결과가 없습니다.😥</b>
              검색어를 다시 확인해주세요. <br>
              Tip.혹시 영문이 아닌 문자로 검색하셨나요?
            </li>
          </ul>
        </div>
      </div>
    </div>
    <go-top />
  </div>
</template>

<script>
import swal from 'sweetalert';
import PageTitle from '../../components/Header/PageTitle.vue'
import Prod from '../../components/Mypage/SimpleProdRes.vue'
import GoTop from '../../components/GoTop.vue'
import http from '../../utils/http-common.js'
import { mapState } from 'vuex';
export default {
  name: "HaveAdd",
  components: {
    PageTitle,
    Prod,
    GoTop,
  },
  created() {
    this.user_No = this.userInfo.id;
    this.user_id = localStorage.getItem("user_id");
    this.getHaveList();
  },
  computed: {
    ...mapState(["userInfo"])
  },
  methods: {
    getHaveList() {
        http
        .get("/have/list", { params: { user_id : this.user_No}})
        .then((res) => {
          if(res.data.result === "success") {
            this.haveList = res.data.havelist
          } else {
            const reason = res.data.reason
            if(reason === "등록된 목록이 없습니다.")
              return;
            else
              swal("!데이터를 불러오는데 문제가 발생했습니다.")
          }
        })
      },
      getSearchList() {
        this.loadActive = true
        this.error = false
        http.get(`/listPage/search/${this.searchText}`)
            .then((res) => {
              if(res.data.length > 0) {
                setTimeout(() => {
                  this.loadActive = false
                  this.searchList = res.data
                }, 1000)
              } else {
                setTimeout(() => {
                  this.loadActive = false
                  this.error = true
                }, 1000)
              }
            })
            .catch(() => {
              console.log("데이터를 불러오던 중 문제가 발생했습니다.")
            })
      },
      addHave(perfume_id, title) {
            for (let i = 0; i < this.haveList.length; i++) {
                if(perfume_id === this.haveList[i].perfume_id) {
                    // 보유 목록에 이미 있으면
                    swal("이미 보유 중인 향수입니다.")
                    return;
                }
            }
            
            const Form = {
                "user_id" : this.userInfo.id,
                "perfume_id" : perfume_id
            }
            http.post('/have/insert', Form)
                .then((res) => {
                    if(res.data.result === "success") {
                        swal( title + " 향수를 보유 향수에 추가했습니다.");
                    } else {
                        swal("데이터를 처리하는 중 문제가 발생했습니다.")
                    }
                })
        },
  },
  data() {
    return {
      error: false,
      loadActive: false,
      user_No: Number,
      user_id : String,
      selectedProd: {
        id: Number,
        title: String,
      },
      haveList : [],
      searchList: [],
      searchText: '',
    }
  },
}
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
span, p{
  font-family: $kor-font-family;
}
button {
  background: none;
  border: none;
}
#HaveAddRoot {
  width: 100%;
  height: 100%;
  min-height: 1300px;
  position: absolute;
  top: 0;
  left: 0;
}
.body-title {
  font-size: $body-subtitle-font-size;
  font-weight: bold;
}
.search-content-box {
    width: 90%;
    height: 80vh;
    margin: 0 auto;
    display: flex;
    flex-direction: column;
    flex-wrap: nowrap;
    align-content: center;
    align-items: center;
}
.search-box {
  width: 50%;
  height: 35px;
  display: flex;
  flex-direction: row;
  align-content: center;
  justify-content: center;
  align-items: center;
  border-radius: 50px;
  background: $light-color;
}
.search-input {
  width: 80%;
  font-size: $detail-font-size;
}
.search-btn {
  color: $main-color;
}
.search-res-list {
  width: 100%;
  height: 100%;
  border: 1px solid $light-color;
  border-radius: 10px;
  overflow: auto;
}
.search-res-list::-webkit-scrollbar {
  width: 7px;
}
// scrollbar 상태바
.search-res-list::-webkit-scrollbar-thumb {
  background-color: $gray-color;
  border-radius: 10px;
  border: 1px solid $light-color;
}
// scrollbar 전체바
.search-res-list::-webkit-scrollbar-track {
  background-color: $light-color;
  border-radius: 10px;
  margin: 10px;
}
.loading {
  height: 100%;
  display: flex;
  align-content: center;
  justify-content: center;
  align-items: center;
}
.item-list {
    width: 100%;
    margin: 0 auto;
}
.item {
    width: 150px;
    display: inline-block;
}
.error {
    display: flex;
    flex-direction: column;
    align-content: center;
    justify-content: center;
    align-items: center
}
.error > b {
  font-size: $body-font-size;
  padding: 10px;
}
</style>