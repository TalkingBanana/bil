<!-- PageHeader.vue -->
<template>
  <div class="header">
    <nav class="navbar navbar-expand-lg navbar-dark " id="mainNav">
        <router-link to="/" class="navbar-brand js-scroll-trigger">
          <img src="@/assets/imgs/logo_Design1_Type8.png" width="150">
        </router-link>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          MENU
          <i class="fas fa-bars"></i>
        </button>

        <div class="collapse navbar-collapse" id="navbarResponsive">
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
              <router-link to="/study" class="nav-link js-scroll-trigger">교육</router-link> 
            </li> 
            <li class="nav-item">
              <router-link to="/management" class="nav-link js-scroll-trigger">관리 페이지</router-link>
            </li>
          </ul>
        </div>
    </nav>
    <div class="fade-screen"></div>
  </div>
</template>
  
<script>
export default {

}
</script>

<style scoped>

</style>