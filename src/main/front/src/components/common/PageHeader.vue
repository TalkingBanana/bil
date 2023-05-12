<template>
  <nav class="navbar navbar-expand-lg navbar-dark " id="mainNav">
    <div class="container menu-container">
      <router-link to="/" class="navbar-brand js-scroll-trigger">
        <img src="@/assets/imgs/logo_Design1_Type8.png" width="150">
      </router-link>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        MENU
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive" @click="closeMenu">
        <ul class="navbar-nav text-uppercase ml-auto menu">
          <li class="nav-item"> 
            <router-link to="/community" class="nav-link js-scroll-trigger">커뮤니티</router-link> 
          </li>
          <li class="nav-item">
            <router-link to="/knowledge" class="nav-link js-scroll-trigger">지식</router-link> 
          </li>
          <li class="nav-item">
            <router-link to="/question" class="nav-link js-scroll-trigger">Q&A</router-link> 
          </li>
          <li class="nav-item">
            <router-link to="/notice" class="nav-link js-scroll-trigger">공지사항</router-link> 
          </li>
          <li class="nav-item">
            <router-link to="/studyBoard" class="nav-link js-scroll-trigger">교육</router-link> 
          </li> 
          <li class="nav-item">
            <router-link to="/management" class="nav-link js-scroll-trigger">관리 페이지</router-link>
          </li>
          <li class="nav-item">
            <a v-if="this.$store.state.isLogin" @click="fnLogout" class="login-button js-scroll-trigger">로그아웃</a>
          </li>
          <li class="nav-item">
            <router-link to="/user/profile" v-if="this.$store.state.isLogin" class="register-button js-scroll-trigger">마이 페이지</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/user/login" v-if="!this.$store.state.isLogin" class="login-button js-scroll-trigger">로그인</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/user/register" v-if="!this.$store.state.isLogin" class="register-button js-scroll-trigger">회원가입</router-link>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <div class="fade-screen"></div>
</template>
<script>
export default {
  methods: {
    closeMenu() {
      if (window.innerWidth < 992) { // 992px 미만에서만 동작
        const navbarToggler = document.querySelector('.navbar-toggler');
        if (navbarToggler.classList.contains('collapsed')) {
          return; // 메뉴가 닫혀있으면 리턴
        }
        navbarToggler.click(); // 메뉴가 열려있으면 클릭 이벤트를 발생시켜 닫기
      }
    },

    fnLogout() {
      localStorage.removeItem("user_token")
      localStorage.removeItem("user_role")
      location.reload()
    }
  }
};
</script>
