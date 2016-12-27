import { createStore, combineReducers, applyMiddleware, compose } from 'redux'
import { browserHistory } from 'react-router'
import { syncHistory } from 'react-router-redux'
import thunk from 'redux-thunk'
import createLogger from 'redux-logger'
import api from '../middleware/api'
import reducers from '../reducers'

const initialState = {
  snackbar: {
    message: '',
    isShow: false
  },
  user: {
    isRegisterd: true,
    me: null
  },
  article: {
    totalPages: 0,
    page: 0,
    list: []
  }
}

const reduxRouterMiddleware = syncHistory(browserHistory)
const logger = createLogger()

const store = compose(
  applyMiddleware(
    thunk,
    api,
    reduxRouterMiddleware
    ,logger
  )
)(createStore)(reducers, initialState)

export default store;
