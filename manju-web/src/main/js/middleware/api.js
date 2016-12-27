import 'isomorphic-fetch'
import Immutable from 'immutable'
import { routeActions } from 'react-router-redux'

export const CALL_API = Symbol('CALL_API')



function callApi(endpoint){
  const url = endpoint.url
  const method = endpoint.method || "GET"
  const headers = endpoint.headers
  const body = endpoint.body

  let param = {
      method: method,
      headers: headers,
      credentials: 'include'
  }
  if(method !== 'GET' && method !== 'HEAD' && body){
    param['body'] = body
  }

  return fetch(url, param)
    .then(response => {
        console.log(response)
        return response.json().then(json => ({json, response}))
      }
    ).then(({json, response}) => {
      if(!response.ok){
        return Promise.reject(json)
      }
      if(Array.isArray(json)){
        return Object.assign([], json)
      }
      return Object.assign({}, json)
    })
}

export default store => next => action => {
  const callAPI =  action[CALL_API]
  if(typeof callAPI === 'undefined'){
    return next(action)
  }

  const { types } = callAPI

  function actionWith(data){
    const finalAction = Object.assign({}, action, data)
    delete finalAction[CALL_API]
    return finalAction
  }

  next(actionWith({type: types.request}))

  return callApi(callAPI.endpoint)
    .then( response => next(actionWith({
        type: types.success,
        payload: response
      }))
    )
    .catch((error) => {
          if(error.status === 401 || error.status === 403){
            setTimeout(location.href='/login')
            return next(actionWith({
              type: types.failure,
              error: error
            }))
          }

          return next(actionWith({
            type: types.failure,
            error: error
          }))
      }
    )
}
