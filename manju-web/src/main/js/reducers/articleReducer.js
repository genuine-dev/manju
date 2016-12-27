import Immutable from 'immutable'
import {
  REGISTER_ARTICLE_REQUEST,
  REGISTER_ARTICLE_SUCCESS,
  REGISTER_ARTICLE_FAILURE,
  FIND_ALL_ARTICLE_REQUEST,
  FIND_ALL_ARTICLE_SUCCESS,
  FIND_ALL_ARTICLE_FAILURE,
  FIND_ARTICLE_BY_TAG_REQUEST,
  FIND_ARTICLE_BY_TAG_SUCCESS,
  FIND_ARTICLE_BY_TAG_FAILURE,
  FIND_ARTICLE_BY_KEYWORD_REQUEST,
  FIND_ARTICLE_BY_KEYWORD_SUCCESS,
  FIND_ARTICLE_BY_KEYWORD_FAILURE
} from '../actions/articleAction'

var handler = {}

handler[REGISTER_ARTICLE_SUCCESS] = (state, action) => {
  return state
}

handler[REGISTER_ARTICLE_FAILURE] = (state, action) => {
  return state
}

handler[FIND_ALL_ARTICLE_SUCCESS] = (state, action) => {
  return Immutable.fromJS(state)
          .set('list', action.payload.content)
          .set('totalPages', action.payload.totalPages)
          .set('page', action.payload.number)
          .toJS()
}

handler[FIND_ARTICLE_BY_TAG_SUCCESS] = (state, action) => {
  return Immutable.fromJS(state)
          .set('list', action.payload.content)
          .set('totalPages', action.payload.totalPages)
          .set('page', action.payload.number)
          .toJS()
}
handler[FIND_ARTICLE_BY_KEYWORD_SUCCESS] = (state, action) => {
  return Immutable.fromJS(state)
          .set('list', action.payload.content)
          .set('totalPages', action.payload.totalPages)
          .set('page', action.payload.number)
          .toJS()
}

export function articleReducer(state = {}, action){
  if(!handler[action.type]){
    return state
  }

  return handler[action.type](state, action)
}
