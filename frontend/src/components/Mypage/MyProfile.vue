<template>
  <div id="MyProfileRoot">
    <div class="profile-box">
      <p class="user-id">| {{user.id}}</p>
      <div class="scents-box">
        <!-- accords -->
        <table class="accords-table">
          <tr>
            <td colspan="2" class="accords-1">
              {{user.accords[0]}}
            </td>
          </tr>
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
          <tr>
            <td colspan="2" class="notes-1">
              {{user.notes[0]}}
            </td>
          </tr>
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
}
.scents-box {
  width: 100%;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  align-content: center;
  justify-content: center;
  align-items: center;
}
.accords-table, .notes-table {
  display: inline-block;
  border: 1px solid black;
}
.accords-table, .notes-table > tr {
}
.accords-table, .notes-table > tr > td {
  text-align: center;
}
</style>