import * as types from './mutation_types'

export default {
    [types.ID] (state, id) {
        state.id = id
    },
    [types.ERROR_STATE] (state, errorState) {
        state.errorState = errorState
    },
    [types.IS_AUTH] (state, isAuth) {
        state.isAuth = isAuth
    }
}