<template>
    <div class="login">
      <div id="loginForm">
        <form @submit.prevent="fnLogin">
          <h1>아이디</h1>
          <p>
            <input class="w3-input" name="uid" placeholder="Enter your ID" v-model="id"><br>
          </p>
          <h1>비밀번호</h1>
          <p>
            <input name="password" class="w3-input" placeholder="Enter your password" v-model="pwd" type="password">
          </p>
          <p>
            <button type="submit" class="w3-button w3-green w3-round">Login</button>
          </p>
        </form>
      </div>
    </div>
  </template>

<script>
import {mapActions, mapGetters} from 'vuex' 

export default {
  data() {
    return {
      id: '',
      pwd: ''
    }
  },
  methods: {
    ...mapActions(['login']),     //vuex/actions에 있는 login 함수

    async fnLogin() {       
      if (this.id === '') {
        alert('ID를 입력하세요.')
        return
      }

      if (this.pwd === '') {
        alert('비밀번호를 입력하세요.')
        return
      }

      //로그인 API 호출 
      try {
        let loginResult = await this.login({id: this.id, pwd: this.pwd})
        if (loginResult) this.goToPages()
      } catch (err) {
        if (err.message.indexOf('Network Error') > -1) {
          alert('서버에 접속할 수 없습니다. 상태를 확인해주세요.')
        } else {
          alert('로그인 정보를 확인할 수 없습니다.')
        }
      }
    },
    goToPages() {
      this.$router.push({
        name: 'home'
      })
    }
  },

  computed: {
    ...mapGetters({
      errorState: 'getErrorState'
    })
  }
}

</script>
  