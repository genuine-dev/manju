import Immutable from 'immutable'
import {
  LOAD_ME_REQUEST,
  LOAD_ME_SUCCESS,
  LOAD_ME_FAILURE,
  REGISTER_USER_REQUEST,
  REGISTER_USER_SUCCESS,
  REGISTER_USER_FAILURE
} from '../actions/userAction'

var handler = {}

handler[LOAD_ME_SUCCESS] = (state, action) => {
  return Immutable.fromJS(state)
           .set('isRegisterd', true)
           .set('me', action.payload)
           .toJS()
  return state
}

handler[LOAD_ME_FAILURE] = (state, action) => {
   return Immutable.fromJS(state)
            .set('isRegisterd', false)
            .toJS()
  return state
}

handler[REGISTER_USER_SUCCESS] = (state, action) => {
  console.log('SUCCESS', state)
  return state
}

handler[REGISTER_USER_FAILURE] = (state, action) => {
  console.log('FAILURE', state)
  return state
}

export function userReducer(state = {}, action){
  if(!handler[action.type]){
    return state
  }

  return handler[action.type](state, action)
}
