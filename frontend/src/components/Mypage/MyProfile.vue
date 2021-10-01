<template>
  <div id="MyProfileRoot">
    <div class="profile-box">
      <p class="user-id">| {{user_id}}
        <router-link to="/mypage/modify" class="user-edit-btn"><i class="fas fa-user-edit edit-btn"></i></router-link>
      </p>
      <div class="scents-box">
        <!-- accords -->
        <table class="accords-table">
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
import { mapState } from 'vuex';
import http from '../../utils/http-common.js'
export default {
  name: "MyProfile",
  computed: {
    ...mapState(["userInfo"])
  },
  created() {
    this.getUser(),
    console.log(this.userInfo)
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
            console.log("axios 요청 성공 후 user info")
            console.log(this.user)
          } else {
            alert("에러가 발생했습니다.");
          }
        })
        .catch(() => {
          alert("에러 발생!");
        });
    },
    infoChk() {
      // if()
    },
  },
  data() {
    return {
      user: {},
      user_id: String,
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