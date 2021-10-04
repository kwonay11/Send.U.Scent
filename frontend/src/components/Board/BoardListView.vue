// 공지사항, 문의하기 게시판 목록
<template>
  <div id="BoardListRoot">
    <!-- <h1>공지사항목록들</h1> -->
    <!-- {{ notices }}  -->
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
          <td class="list">{{ notice.title }}</td>
          <td class="list">{{ notice.createdDate.anua }}</td>
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
    };
  },
  beforeCreate() {
    console.log("공지사항 목록들 디스패치");

    axios
      .get("http://localhost:8888/suscent/api/notices/") // user_id, password
      .then((res) => {
        console.log(res);
        console.log("목록 소환 성공");
        this.notices = res.data;
      })
      .catch(() => {
        console.log("목록을 못 불러왔음");
      });
  },
  name: "BoardListView",
};
</script>

<style scoped>
thead {
  border-bottom: 1px solid black;
}
table {
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
