import React from 'react'
import { render }from 'react-dom'
import { browserHistory } from 'react-router'
import store from './store'
import Root from './containers/Root'

render(
  <Root store={store} history={browserHistory} />,
  document.getElementById('root')
)
