// 상단 Nav bar
<template>
    <div id="NavRoot">
    
            
            <div class="logo"><router-link to="/">Send.U.Scent</router-link></div>
        
            <div class="menu-item-rec" >
                <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Recommend
                </a>
                    <ul class="dropdown-menu dropdown-menu-dark mt-3" aria-labelledby="navbarDarkDropdownMenuLink">
                        <li><div class="drop-item"><router-link to="/recommend">ALL</router-link></div></li>
                        <li><div class="drop-item"><router-link to="/recommend/perfume">Perfume</router-link></div></li>
                        <li><div class="drop-item"><router-link to="/recommend/softener">Softener</router-link></div></li>
                        <li><div class="drop-item"><router-link to="/recommend/test">Test For Me</router-link></div></li>
                        <li><div class="drop-item"><router-link to="/recommend/test">Test For Dear</router-link></div></li>
                    </ul>
            </div>
            
            <div class="menu-item" style="padding:20px"><router-link to="/about">About</router-link></div>

            <div class="menu-item" >
                <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Community
                </a>

                    <ul class="dropdown-menu dropdown-menu-dark mt-3 " aria-labelledby="navbarDarkDropdownMenuLink">
                        <li><div class="drop-item"><router-link to="/notice">Notice</router-link></div></li>
                        <li><div class="drop-item"><router-link to="/qna">QnA</router-link></div></li>
                    </ul>
            </div>
            <div class="menu-item" >
                <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    User
                </a>

                    <ul class="dropdown-menu dropdown-menu-dark mt-3 " aria-labelledby="navbarDarkDropdownMenuLink">
                        <li><div class="drop-item"><router-link to="/signup">Signup</router-link></div></li>
                        <li><div class="drop-item"><router-link to="/qna">Login</router-link></div></li>
                    </ul>
            </div>

            <div class="menu-item" style="padding:20px"><router-link to="/mypage"><img src="@/assets/icons/mypage-btn.png" alt="mypage" style="width:1vw"></router-link></div>
            <!-- 로그인 상태일 때 로그아웃 처리해야함-->
            <div class="menu-item" style="margin-right:2vw;padding:20px"><router-link to="/logout"><img src="@/assets/icons/Logout-btn.png" alt="logout" style="width:1.2vw"></router-link></div>

       
 


    </div>
</template>

<style lang="scss" scoped>
@import "../../styles/common.scss";


#NavRoot {
    background-color: #78949D;
    display: flex;
    align-items: center;
    justify-content:flex-end;
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    z-index: 10000;
    box-shadow: 1px 1px  7px  3px rgba(129, 127, 127, 0.849);
}
#NavRoot .logo a{
    font-family: $eng-font-family;
    font-size: $title-font-size;
    font-weight: bold;
   margin-left: 2vw;
    font-size: 2vw;
    text-decoration:none;
    position: absolute;
    top: 1.5vh; left: 0vw;

  
}
#NavRoot .menu-item {
    font-family: $eng-font-family;
    padding-top:0.8%;
    padding-bottom:0.8%;
    // margin-left:0.2%;
    // padding-right:0.5%;
    /* padding: 10px; */
    position: relative;
    text-align: center;
    border-bottom: 5px solid transparent;
    // display: flex;
     transition: 0.4s; 
}


#NavRoot .menu-item.active,
#NavRoot .menu-item:hover {
    background-color: #4F4F4F;
    border-bottom-color: #DDC9C6;
    
}
#NavRoot .menu-item a {
    /* color: inherit; */
    text-decoration: none;
    
}
#NavRoot .drop-item {
    position: relative;
    text-align: center;
 
   
}
#NavRoot .drop-item.active,
#NavRoot .drop-item:hover {
    background-color: #DDC9C6;
    color:#4F4F4F;
   
}

#NavRoot .drop-item a {
    text-decoration: none;
}



#NavRoot a {
//   font-weight: bold;
  color: white;
}

#NavRoot .menu-item a.router-link-exact-active {
  color: #DDC9C6;
}

.dropdown-toggle::after {
    // 삼각형
    display: none;
 
}

.dropdown-menu-dark {
  
    background-color: #4F4F4F;

}
 .menu-item .dropdown-menu {
    z-index: 1000;
    min-width: 6rem;
    border-radius:0;
    padding: 6%;
    

}

// 추천
#NavRoot .menu-item-rec {
    font-family: $eng-font-family;
    padding-top:0.8%;
    padding-bottom:0.8%;
    padding-left:0.4%;
    padding-right:0.4%;
    /* padding: 10px; */
    position: relative;
    text-align: center;
    border-bottom: 5px solid transparent;
    // display: flex;
     transition: 0.4s; 
}
#NavRoot .menu-item-rec.active,
#NavRoot .menu-item-rec:hover {
    background-color: #4F4F4F;
    border-bottom-color: #DDC9C6;
    
}
#NavRoot .menu-item-rec a {
    /* color: inherit; */
    text-decoration: none;
    
}
#NavRoot .drop-item {
    position: relative;
    text-align: center;
 
   
}
#NavRoot .drop-item.active,
#NavRoot .drop-item:hover {
    background-color: #DDC9C6;
    color:#4F4F4F;
   
}

#NavRoot .drop-item a {
    text-decoration: none;
}



#NavRoot a {
//   font-weight: bold;
  color: white;
}

#NavRoot .menu-item-rec a.router-link-exact-active {
  color: #DDC9C6;
}

.dropdown-toggle::after {
    // 삼각형
    display: none;
 
}

.dropdown-menu-dark {
  
    background-color: #4F4F4F;

}
 .menu-item-rec .dropdown-menu {
    z-index: 1000;
    min-width: 7.5rem;
    border-radius:0;
    padding: 6%;
    

}


</style>