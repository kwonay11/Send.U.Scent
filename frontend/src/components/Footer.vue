// Footer
<template>
    <div id="FooterRoot">
        <div class="name">Send.U.Scent</div>
        <div class="info">서비스소개 | 팀소개 | 사이트맵</div>
        <div class="team">Developed by TEAM. C204</div>


    </div>
</template>

<script>
export default {
    name:'Footer',

}
</script>

<style scoped>
#FooterRoot{
    background:#242424;
    height:28vh;
}
.name{
    color:#78949D;
    padding-top: 5vh;
    padding-left: 5vh;
    font-size: 30px;
    height: 100px;
    display: flex;
    font-weight: bold;
}
.info{
    color:white;
    height: 30px;
    margin-left: 5vh;
    margin-top: -2vh;;
    height: 100px;
    display: flex;
    
}
.team{
    color:white;
    margin: -4vh;
 
}

</style>