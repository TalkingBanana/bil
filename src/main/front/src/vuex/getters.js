export default {
    getId: state => state.id,
    getErrorState: state => state.errorState,
    getIsAuth: state => state.isAuth,
    loggedIn(state) {
      return !!state.user
    }
  }