// 상단 Nav bar
<template>
    <div id="NavRoot">
        <nav>
            
            <div class="logo"><router-link to="/">Send.U.Scent</router-link></div>
        
            <div class="menu-item p-0">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Recommend&nbsp;&nbsp;
                </a>
                    <ul class="dropdown-menu dropdown-menu-dark mt-1" aria-labelledby="navbarDarkDropdownMenuLink">
                        <li><div class="drop-item"><router-link to="/all">ALL</router-link></div></li>
                        <li><div class="drop-item"><router-link to="/perfume">Perfume</router-link></div></li>
                        <li><div class="drop-item"><router-link to="/softener">Softener</router-link></div></li>
                        <li><div class="drop-item"><router-link to="/test">Test For Me</router-link></div></li>
                        <li><div class="drop-item"><router-link to="/test">Test For Dear</router-link></div></li>
                    </ul>
            </div>
            
            <div class="menu-item"><router-link to="/about">About</router-link></div>

            <div class="menu-item p-0">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Community&nbsp;&nbsp;&nbsp;
                </a>
                    <ul class="dropdown-menu dropdown-menu-dark mt-1" aria-labelledby="navbarDarkDropdownMenuLink">
                        <li><div class="drop-item"><router-link to="/notice">Notice</router-link></div></li>
                        <li><div class="drop-item"><router-link to="/qna">QnA</router-link></div></li>
                    </ul>
            </div>

            <div class="menu-item"><router-link to="/mypage">&nbsp;<img src="@/assets/icons/mypage-btn.png" alt="mypage" style="width:1vw">&nbsp;</router-link></div>
            <!-- 로그인 상태일 때 로그아웃 처리해야함-->
            <div class="menu-item" style="margin-right:2vw;"><router-link to="/logout">&nbsp;<img src="@/assets/icons/Logout-btn.png" alt="logout" style="width:1.2vw">&nbsp;</router-link></div>

       
 

        </nav>

    </div>
</template>

<style scoped>
nav {
    padding: 1%;
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
nav .logo a{
   margin-left: 2vw;
    font-size: 2vw;
    text-decoration:none;
    position: absolute;
    top: 1.5vh; left: 0vw;

  
}
nav .menu-item {
  
    
    padding: 10px;
    position: relative;
    text-align: center;
    border-bottom: 5px solid transparent;
    display: flex;
    transition: 0.4s;
}


nav .menu-item.active,
nav .menu-item:hover {
    background-color: #4F4F4F;
    border-bottom-color: #DDC9C6;
}
nav .menu-item a {
    color: inherit;
    text-decoration: none;
}
nav .drop-item {
  
    padding: 10px;
    position: relative;
    text-align: center;
    display: flex;
    transition: 0.4s;
}
nav .drop-item.active,
nav .drop-item:hover {
    background-color: #4F4F4F;
   
}

nav .drop-item a {
    color: inherit;
    text-decoration: none;
}



#nav a {
  font-weight: bold;
  color: white;
}

#nav .menu-item a.router-link-exact-active {
  color: #DDC9C6;
}
</style>