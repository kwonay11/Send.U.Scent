// 관심목록 리스트 페이지
<template>
    <div id="WantListRoot">
        <page-title pageTitle="I want" />
            <div class="content-box mt-5 my-3">
                <p class="body-title">회원님이 관심을 가진 향수에요</p>
            <div class="have-list">
                <ul class="item-list">
                    <li class="item m-3"  v-for="(item, index) in wantList" :key="index">
                    <Prod :id="item.id" :perfume_id="item.perfume_id" :name="item.title" @click.prevent="addHave(item.perfume_id, item.title)"/>
                    </li>
                </ul>
            </div>
        </div>
        <!-- <Modal v-if="setModal" @flag="closeModal" :id="this.selectedProd.id" :name="this.selectedProd.title"/> -->
        <div id="ModalRoot" v-if="setModal">
        <div class="black-bg">
            <div class="modal-box p-3">
                <div class="modal-top">
                    <p class="modal-title">가지고 있는 목록에 추가하시겠습니까?</p>
                </div>
                <div class="modal-middle">
                    <p class="perfume-name">" {{this.selectedProd.title}} "</p>
                </div>
                <div class="modal-bottom">
                    <div class="button-group">
                        <button class="cancel-btn" @click="closeBtn">취소</button>
                        <button class="add-btn" @click="addBtn">추가</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
        
        <go-top />
    </div>
</template>

<script>
import PageTitle from '../../components/Header/PageTitle.vue';
import Prod from '../../components/SimpleProd.vue';
// import Modal from '../../components/Modal.vue';
import GoTop from '../../components/GoTop.vue';
import http from '../../utils/http-common.js'
import { mapState } from 'vuex';
export default {
    name: "WantList",
    components: {
        PageTitle,
        Prod,
        // Modal,
        GoTop,
    },
    computed: {
        ...mapState(["userInfo"])
    },
    created() {
        this.user_No = this.userInfo.id;
        this.getList();
        this.getHaveList();
    },
    methods: {
        getList() {
            http
            .get("/like/list", { params: { user_id : this.user_No}})
            .then((res) => {
                if(res.data.result === "success") {
                this.wantList = res.data.wantlist
                // console.log(this.haveList)
                } else {
                alert("!데이터를 불러오는데 문제가 발생했습니다.")
                }
            })
        },
        getHaveList() {
            http
            .get("/have/list", { params: { user_id : this.user_No}})
            .then((res) => {
            if(res.data.result === "success") {
                this.haveList = res.data.havelist
                // console.log(this.haveList)
            } else {
                alert("!데이터를 불러오는데 문제가 발생했습니다.")
            }
            })
        },
        addHave(perfume_id, title) {
            // alert(id + "번 향수 리뷰");
            for (let i = 0; i < this.haveList.length; i++) {
                if(perfume_id === this.haveList[i].perfume_id) {
                    // 보유 목록에 이미 있으면
                    alert("이미 보유 중인 향수입니다.")
                    return;
                }
            }
            this.setModal = true;
            this.selectedProd.id = perfume_id;
            this.selectedProd.title = title;
            console.log(this.selectedProd)
        },
        closeModal() {
            this.setModal = false;
        },
        closeBtn() {
            this.setModal = false;
        },
        addBtn() {
            const Form = {
                "user_id" : this.userInfo.id,
                "perfume_id" : this.selectedProd.id
            }
            console.log(Form)
            http.post('/have/insert', Form)
                .then((res) => {
                    if(res.data.result === "success") {
                        alert(this.name + " 향수를 보유 향수에 추가했습니다.");
                        this.closeBtn()
                        this.$router.go()
                    } else {
                        alert("데이터를 처리하는 중 문제가 발생했습니다.")
                    }
                })
        },
    },
    data() {
        return {
            setModal: false,
            selectedProd: {
                id: Number,
                title: String,
            },
            wantList : [],
            haveList: [],
        }
    },
}
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
* {
    font-family: $kor-font-family;
}
#WantListRoot {
    width: 100%;
    height: 100%;
    min-height: 1300px;
    position: absolute;
    top: 0;
    left: 0;
    overflow: auto;
  /* for Firefox */
    scrollbar-width: none;
    /* for IE, Edge */
    -ms-overflow-style: none;
}
#WantListRoot::-webkit-scrollbar {
    display: none;
}
.body-title {
    font-size: $body-subtitle-font-size;
    font-weight: bold;
}
.item-list {
    width: 800px;
    margin: 0 auto;
}
.item {
    width: 120px;
    display: inline-block;
}


// 모달
#ModalRoot {
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
  width: 370px;
  height: 260px;
  position: relative;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: white;
  border-radius: 10px;
  box-shadow: 0px 4px 20px 5px rgba(0, 0, 0, 0.25);
  z-index: 20;
  display: grid;
  align-content: space-evenly;
  justify-content: center;
  align-items: center;
  justify-items: center;
}
.modal-top {
  
}
.modal-top > .modal-title {
  font-size: $body-font-size;
  font-weight: 700;
}
.modal-middle {
  width: 100%;
}
.perfume-name {
    font-size: $bodytitle-font-size;
    font-weight: bold;
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
	width: 40%;
	height: 35px;
	border: none;
	border-radius: 50px;
	background: $gray-color;
	margin-right: 25px;
}
.add-btn {
	width: 40%;
	height: 35px;
	border: none;
	border-radius: 50px;
	background: $point-color;
}
</style>