import React , { Component, PropTypes } from 'react'
import { Provider } from 'react-redux'
import { Router, Route, IndexRoute } from 'react-router'
import App from './App'
import Article from './Article'
import NewArticle from './article/NewArticle'
import ArticleList from './article/ArticleList'
import ArticleListByTag from './article/ArticleListByTag'

export default class Root extends Component {
  constructor(props){
    super(props)

    this.routes = {
      path: '/',
      component: App,
      indexRoute: {
              onEnter: (nextState, replace) => {
                replace(`article`)
              }
            },
      childRoutes: [
        {
          path: 'article',
          component: Article,
          indexRoute: {
            onEnter: (nextState, replace) => {
              replace(`article/list`)
            }
          },
          childRoutes: [
            {
              path: 'new',
              component: NewArticle
            },
            {
              path: 'list',
              component: ArticleList
            } ,
            {
              path: 'tag/:tag',
              component: ArticleListByTag
            }
          ]
        }
      ]
    }
  }
  render(){
    const { store, history } = this.props
    return (
      <Provider store={store}>
        <div>
          <Router history={history} routes={this.routes}/>
        </div>
      </Provider>
    )
  }
}

Root.propTypes = {
  store: PropTypes.object.isRequired,
  history: PropTypes.object.isRequired
}
