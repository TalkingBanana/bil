<template>
  <div class="register">
    <div>
      <h1>회원가입</h1>
      <form @submit.prevent="register">
        <div>
          <label for="id">아이디:</label>
          <input type="text" v-model="member.id" id="id" required />
        </div>
        <div>
          <label for="pwd">비밀번호:</label>
          <input type="password" v-model="member.pwd" id="pwd" required />
        </div>
        <div>
          <label for="nickname">닉네임:</label>
          <input type="text" v-model="member.nickname" id="nickname" required />
        </div>
        <button type="submit">회원가입</button>
      </form>
    </div>
  </div>
</template>
<script>
import axios from 'axios';

export default {
  data() {
    return {
      member: {
        id: '',
        pwd: '',
        nickname: ''
      }
    }
  },
  methods: {
    register() {
      // id 중복 검사
      axios.get(`/user/checkid?id=${this.member.id}`)
        .then(response => {
          if (response.data === 'duplicated') {
            alert('중복된 id입니다');
            return;
          }

          // nickname 중복 검사
          axios.get(`/user/checknickname?nickname=${this.member.nickname}`)
            .then(response => {
              if (response.data === 'duplicated') {
                alert('닉네임이 중복됩니다');
                return;
              }

              // pwd 유효성 검사
              if (this.member.pwd.length < 8) {
                alert('비밀번호가 너무 짧습니다');
                return;
              }
              if (this.member.pwd.length > 14) {
                alert('비밀번호가 너무 깁니다');
                return;
              }

              // 회원가입 요청
              axios.post('/user/register', this.member)
                .then(response => {
                  alert(response.data);
                  // 회원가입 성공 후 로그인 페이지로 이동
                  this.$router.push({
                    name: "login"
                  });
                })
                .catch(error => {
                  console.log(error);
                  alert('회원가입 실패');
                });
            })
            .catch(error => {
              console.log(error);
              alert('닉네임 중복 검사 실패');
            });
        })
        .catch(error => {
          console.log(error);
          alert('아이디 중복 검사 실패');
        });
    }
  }
}
</script>