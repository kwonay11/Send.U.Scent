<template>
  <div id="MyProfileRoot">
    <div class="profile-box">
      <p class="user-id">| {{userInfo.nickname}}
        <router-link to="/mypage/modify" class="user-edit-btn"><i class="fas fa-user-edit edit-btn"></i></router-link>
      </p>
      <div class="scents-box">
        <table v-if="chkAccord" class="accords-table">
          <th>
            <td class="chk-accord-text">
              내 취향의 Accord 정보가 없어요! <br>
              지금 바로 테스트를 통해 알아볼까요?<br>
              <router-link to="/recommend/mytest">테스트 하기📝</router-link>
            </td>
          </th>
        </table>
        <table v-else class="accords-table">
          <th>
            <td colspan="2" class="accords-1">
              {{user.accord1}}
            </td>
          </th>
          <tr>
            <td class="accords-2">
              {{user.accord2}}
            </td>
            <td class="accords-3">
              {{user.accord3}}
            </td>
          </tr>
          <tr>
            <td class="accords-4">
              {{user.accord4}}
            </td>
            <td class="accords-4">
              {{user.accord5}}
            </td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import swal from 'sweetalert';
import { mapState } from 'vuex';
import http from '../../utils/http-common.js'
export default {
  name: "MyProfile",
  computed: {
    ...mapState(["userInfo"])
  },
  created() {
    this.getUser();
  },
  methods: {
    getUser() {
      this.user_id = localStorage.getItem("user_id")
      http
        .get("/user/info", { params: { user_id: this.user_id } })
        .then((res) => {
          if (res.data.result === "success") {
            this.$store.commit("setUserInfo", res.data.user);
            this.user = this.userInfo;
            if(this.user.accord1 === null) {
              this.chkAccord = true
            }
          } else {
            swal("에러가 발생했습니다.");
          }
        })
        .catch(() => {
          swal("에러 발생!");
        });
    },
  },
  data() {
    return {
      user: {},
      user_id: String,
      chkAccord: false,
    }
  }

}

</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
#MySProfileRoot {
  width: 100%;
}
.profile-box {
  width: 100%;
  height: 340px;
  background-color: $white-color;
  border-radius: 10px;
  padding: 20px 30px;
}
.user-id {
  text-align: left;
  font-family: $kor-font-family;
  font-size: $bodytitle-font-size;
  font-weight: 700;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  align-content: center;
  align-items: center;
}
.user-edit-btn {
  width: 25px;
  height: 25px;
  border-radius: 5px;
  border: none;
  background-color: $gray-color;
  display: inline-grid;
  flex-direction: row;
  flex-wrap: nowrap;
  align-content: center;
  justify-content: center;
  align-items: center;
  margin-left: 10px;
}
.edit-btn {
  font-size: $detail-font-size;
  color: $dark-color;
}
.scents-box {
  width: 100%;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  align-content: center;
  justify-content: space-around;
  align-items: center;
}
.accords-table, .notes-table {
  display: inline-block;
  // border: 1px solid black;
  width: 60%;
  height: 200px;
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  align-content: center;
  justify-content: center;
  align-items: center;
}
.chk-accord-text > a {
  margin-top: 30px;
  color: $point-color;
  font-size: $body-font-size;
  line-height: 2.6em;
}
.chk-accord-text > a:hover {
  color: $heart-color;
}
tr,th {
  height: 60px;
}
td {
  width: 40vw;
  height: inherit;
  font-weight: 700;
}
.accords-table, .notes-table > tr > td {
  text-align: center;
}
.accords-1 {
  font-size: 2.5em;
}
.accords-2 {
  font-size: 2.0em;
}
.accords-3 {
  font-size: 1.7em;
}
.accords-4 {
  font-size: 1.3em;
  color: gray;
}
</style>