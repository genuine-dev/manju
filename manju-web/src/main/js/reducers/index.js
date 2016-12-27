import { combineReducers } from 'redux'
import { routeReducer } from 'react-router-redux'
import { userReducer } from './userReducer'
import { articleReducer } from './articleReducer'

const reducers = combineReducers({
  user: userReducer,
  routing: routeReducer,
  article: articleReducer
});

export default reducers;
