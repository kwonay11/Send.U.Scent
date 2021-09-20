<template>
  <div id="MyProfileRoot">
    <div class="profile-box">
      <p class="user-id">| {{user.id}}
        <router-link to="/mypage/modify" class="user-edit-btn"><i class="fas fa-user-edit edit-btn"></i></router-link>
      </p>
      <div class="scents-box">
        <!-- accords -->
        <table class="accords-table">
          <th>
            <td colspan="2" class="accords-1">
              {{user.accords[0]}}
            </td>
          </th>
          <tr>
            <td class="accords-2">
              {{user.accords[1]}}
            </td>
            <td class="accords-3">
              {{user.accords[2]}}
            </td>
          </tr>
        </table>
        <!-- notes -->
        <table class="notes-table">
          <th>
            <td colspan="2" class="notes-1">
              {{user.notes[0]}}
            </td>
          </th>
          <tr>
            <td class="notes-2">
              {{user.notes[1]}}
            </td>
            <td class="notes-3">
              {{user.notes[2]}}
            </td>
          </tr>
          <tr>
            <td class="notes-4">
              {{user.notes[3]}}
            </td>
            <td class="notes-5">
              {{user.notes[4]}}
            </td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MyProfile",
  data() {
    return {
      user: {
        id: "User_id",
        accords : ["Accord1", "Accord2", "Accord3"],
        notes: ["#Note1","#Note2","#Note2","#Note4","#Note5",],
      }
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
  width: 40%;
  height: 200px;
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  align-content: center;
  justify-content: center;
  align-items: center;
}
tr,th {
  height: 50px;
}
td {
  width: 40vw;
  height: inherit;
  font-weight: 700;
}
.accords-table, .notes-table > tr > td {
  text-align: center;
}
.accords-1, .notes-1 {
  font-size: 1.7em;
}
.accords-2, .notes-4 {
  font-size: 1.2em;
}
.notes-2 {
  font-size: 1.5em;
}
.notes-3 {
  font-size: 1.3em;
}
</style>