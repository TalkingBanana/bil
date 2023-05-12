<template>
  <header class="masthead">
    <div class="container">
      <div class="intro-text">
        <div class="intro-lead-in">Welcome To <br/>Bridge International Ltd.</div><br/><br/>
        <div class="intro-heading text-uppercase">We believe in the power of the team.</div>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: 'HomeView',
  mounted() {
    const token = localStorage.getItem('user_token')
    if (token) {
      this.$store.state.isLogin = true
    }
  },
  computed: {
    isLogin() {
      return this.$store.state.isLogin
    },
  },
  components: {
  }
}
</script>