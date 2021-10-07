// 공지사항, 문의하기 게시판 목록
<template>
  <div id="BoardListRoot">
    <button
      type="button"
      class="btn btn-primary"
      @click="goCreate"
      v-if="isAdmin"
    >
      공지생성
    </button>
    <table>
      <thead>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>일자</th>
        </tr>
      </thead>
      <tbody>
        <tr :key="i" v-for="(notice, i) in notices" class="mylist">
          <td class="list">{{ i + 1 }}</td>
          <td class="list" @click="goread(i)">
            {{ notice.title }}
          </td>
          <td class="list">{{ this.date_refine[i][0] }}</td>
          <!-- <button
            type="button"
            class="btn btn-success"
            v-if="isAdmin"
            @click="goupdate(i)"
          >
            수정
          </button> -->
          <button
            type="button"
            class="btn btn-danger"
            v-if="isAdmin"
            @click="goDelete(notice.id)"
          >
            X
          </button>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      notices: [],
      isAdmin: false,
    };
  },
  computed: {
    date_refine() {
      let date_arr = [];
      console.log("디버깅");
      console.log(this.notices);
      for (let n of this.notices) {
        if (n.createdDate == null) {
          n.createdDate = "2021-10-08T0";
          // let today = new Date();
          // console.log("today");
          // console.log(today);
        }
        date_arr.push(n.createdDate.split("T"));
      }
      return date_arr;
    },
  },
  methods: {
    goread(i) {
      console.log("고");
      this.$router.push("/notice/" + i);
    },
    goupdate(i) {
      console.log("고");
      this.$router.push("/notice/modify/" + i);
    },
    goCreate() {
      console.log("생성고");
      this.$router.push("/notice/write");
    },
    goDelete(n) {
      console.log("제거고");
      axios
        .delete(`https://j5c204.p.ssafy.io/suscent/api/notices/delete/${n}`)
        .then((res) => {
          console.log(res);
          console.log("제거 성공");
          this.$router.go();
        })
        .catch(() => {
          console.log("제거 실패");
        });
    },
  },
  beforeCreate() {
    console.log("공지사항 목록들 디스패치");

    axios
      .get("https://j5c204.p.ssafy.io/suscent/api/notices/")
      .then((res) => {
        // console.log(res);
        console.log("목록 소환 성공");
        // this.notices = res.data;
        console.log(this.notices);
      })
      .catch(() => {
        console.log("목록을 못 불러왔음");
      });
  },
  created() {
    let user_id = localStorage.getItem("user_id");
    // console.log(this.user_id);
    if (user_id == "admin") {
      this.isAdmin = true;
      console.log("안녕하세요 관리자님");
    }
  },
  name: "BoardListView",
};
</script>

<style scoped>
thead {
  border-bottom: 1px solid black;
}
table {
  cursor: pointer;
  border-collapse: collapse;
  width: 100%;
}
.list {
  padding: 5px 0px 5px 5px;
  margin-bottom: 5px;
  border-bottom: 1px solid #efefef;
  font-size: 20px;
}
</style>
