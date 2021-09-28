// 모달창(관심목록에 추가, 내가 가진 목록에 추가)
<template>
    <div id="ModalRoot">
        <div class="black-bg">
            <div class="modal-box p-3">
                <div class="modal-top">
                    <p class="modal-title">가지고 있는 목록에 추가하시겠습니까?</p>
                </div>
                <div class="modal-middle">
                    <p class="perfume-name">" {{this.name}} "</p>
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
</template>

<script>
export default {
    props: [
        "id",
        "name",
    ],
    methods: {
        closeBtn() {
            this.$emit("flag", false);
            },
        addBtn() {
            console.log(this.prodInfo);
            alert(this.name + " 향수를 보유 향수로 이동");
            this.$emit("flag", false);
        },
    },
    mounted() {
        this.prodInfo.perfume_id = this.id;
        this.prodInfo.perfume_name = this.name;
    },
    data() {
        return {
            prodInfo : {
                perfume_id: Number,
                perfume_name: String,
            }
        }
    },
}
</script>

<style lang="scss" scoped>
@import "../styles/common.scss";
* {
  font-family: $kor-font-family;
}
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
<<<<<<< HEAD
=======
  min-height: 1300px;
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
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
<<<<<<< HEAD
  top: 50%;
=======
  top: 40%;
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
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