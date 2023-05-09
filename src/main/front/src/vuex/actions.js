import {ID, IS_AUTH, ERROR_STATE} from './mutation_types'
import loginAPI from '../service/loginAPI'

let setId = ({commit}, data) => {
  commit(ID, data)
}

let setErrorState = ({commit}, data) => {
  commit(ERROR_STATE, data)
}

let setIsAuth = ({commit}, data) => {
  commit(IS_AUTH, data)
}

// 백엔드에서 반환한 결과값을 가지고 로그인 성공 실패 여부를 vuex에 넣어준다.
let processResponse = (store, loginResponse) => {
  switch (loginResponse) {
    case 'notFound':
      setErrorState(store, 'Wrong ID or Password')
      setIsAuth(store, false)
      break
    default:
      setId(store, loginResponse.id)
      setErrorState(store, '')
      setIsAuth(store, true)
  }
}

export default {
  async login (store, {id, pwd}) {
    let loginResponse = await loginAPI.doLogin(id, pwd)
    processResponse(store, loginResponse)
    return store.getters.getIsAuth  // 로그인 결과를 리턴한다
  }
}