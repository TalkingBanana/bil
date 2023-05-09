import axios from 'axios'

const getUserInfo = (id, pwd) => {
    const reqData = {
      'id': id,
      'pwd': pwd
    }

    let serverUrl = '//localhost:8090'

    return axios.post(serverUrl + '/user/login', reqData, {
      headers: {
        'Content-Type': 'application/json'
      }
    })
  }
  
  export default {
    async doLogin(id, pwd) {
      try {
        const getUserInfoPromise = getUserInfo(id, pwd)
        const [userInfoResponse] = await Promise.all([getUserInfoPromise])
        if (userInfoResponse.data.length === 0) {
          return 'notFound'
        } else {
          localStorage.setItem('user_token', userInfoResponse.data.user_token)
          localStorage.setItem('user_role', userInfoResponse.data.user_role)
          return userInfoResponse
        }
      } catch (err) {
        console.error(err)
      }
    }
  }