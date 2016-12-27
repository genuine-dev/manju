import { CALL_API } from '../middleware/api'
export const REGISTER_ARTICLE_REQUEST = 'REGISTER_ARTICLE_REQUEST'
export const REGISTER_ARTICLE_SUCCESS = 'REGISTER_ARTICLE_SUCCESS'
export const REGISTER_ARTICLE_FAILUER = 'REGISTER_ARTICLE_FAILUER'

export function registerArticle(postData){
  return (dispatch, getState) => {
    return dispatch(
      {
        [CALL_API]: {
          types: {
            request: REGISTER_ARTICLE_REQUEST,
            success: REGISTER_ARTICLE_SUCCESS,
            failure: REGISTER_ARTICLE_FAILUER
          },
          endpoint: {
            url: '/api/article/new',
            method:  'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(postData)
          }
        }
      }
    )
  }
}

export const FIND_ALL_ARTICLE_REQUEST = 'FIND_ALL_ARTICLE_REQUEST'
export const FIND_ALL_ARTICLE_SUCCESS = 'FIND_ALL_ARTICLE_SUCCESS'
export const FIND_ALL_ARTICLE_FAILURE = 'FIND_ALL_ARTICLE_FAILURE'

export function findAllArticle(page){
  return (dispatch, getState) => {
    return dispatch(
      {
        [CALL_API]: {
          types: {
            request: FIND_ALL_ARTICLE_REQUEST,
            success: FIND_ALL_ARTICLE_SUCCESS,
            failure: FIND_ALL_ARTICLE_FAILURE
          },
          endpoint: {
            url: `/api/article?page=${page}`,
            method:  'GET',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            }
          }
        }
      }
    )
  }
}
export const FIND_ARTICLE_BY_KEYWORD_REQUEST = 'FIND_ARTICLE_BY_KEYWORD_REQUEST'
export const FIND_ARTICLE_BY_KEYWORD_SUCCESS = 'FIND_ARTICLE_BY_KEYWORD_SUCCESS'
export const FIND_ARTICLE_BY_KEYWORD_FAILURE = 'FIND_ARTICLE_BY_KEYWORD_FAILURE'

export function findArticleByKeyword(keyword, page){
  return (dispatch, getState) => {
    return dispatch(
      {
        [CALL_API]: {
          types: {
            request: FIND_ARTICLE_BY_KEYWORD_REQUEST,
            success: FIND_ARTICLE_BY_KEYWORD_SUCCESS,
            failure: FIND_ARTICLE_BY_KEYWORD_FAILURE
          },
          endpoint: {
            url: `/api/article/keyword?keyword=${keyword}&page=${page}`,
            method:  'GET',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            }
          }
        }
      }
    )
  }
}
export const FIND_ARTICLE_BY_TAG_REQUEST = 'FIND_ARTICLE_BY_TAG_REQUEST'
export const FIND_ARTICLE_BY_TAG_SUCCESS = 'FIND_ARTICLE_BY_TAG_SUCCESS'
export const FIND_ARTICLE_BY_TAG_FAILURE = 'FIND_ARTICLE_BY_TAG_FAILURE'

export function findArticleByTag(tag, page){
  return (dispatch, getState) => {
    return dispatch(
      {
        [CALL_API]: {
          types: {
            request: FIND_ARTICLE_BY_TAG_REQUEST,
            success: FIND_ARTICLE_BY_TAG_SUCCESS,
            failure: FIND_ARTICLE_BY_TAG_FAILURE
          },
          endpoint: {
            url: `/api/article/tag/${tag}?page=${page}`,
            method:  'GET',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            }
          }
        }
      }
    )
  }
}
