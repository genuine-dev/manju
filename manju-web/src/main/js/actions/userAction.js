import { CALL_API } from '../middleware/api'

export const LOAD_ME_REQUEST = 'LOAD_ME_REQUEST'
export const LOAD_ME_SUCCESS = 'LOAD_ME_SUCCESS'
export const LOAD_ME_FAILURE = 'LOAD_ME_FAILURE'
export function loadMe(){
  return (dispatch, getState) => {
      return dispatch({
        [CALL_API]: {
          types: {
            request: LOAD_ME_REQUEST,
            success: LOAD_ME_SUCCESS,
            failure: LOAD_ME_FAILURE
          },
          endpoint: {
            url: `/api/user/me`
          }
        }
      })
    }
}

export const REGISTER_USER_REQUEST = 'REGISTER_USER_REQUEST'
export const REGISTER_USER_SUCCESS = 'REGISTER_USER_SUCCESS'
export const REGISTER_USER_FAILURE = 'REGISTER_USER_FAILURE'

export function registerUser(){
  return (dispatch, getState) => {
      return dispatch({
        [CALL_API]: {
          types: {
            request: REGISTER_USER_REQUEST,
            success: REGISTER_USER_SUCCESS,
            failure: REGISTER_USER_FAILURE
          },
          endpoint: {
            url: `/api/user/new`,
            method: 'POST'
          }
        }
      })
    }
}
