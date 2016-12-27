import React, { Component, PropTypes } from 'react'
import { connect } from 'react-redux'
import { routeActions } from 'react-router-redux'
import { findAllArticle } from '../../actions/articleAction'
import Article from '../../component/article/Article'

class ArticleList extends Component {
  constructor(props){
    super(props)
  }

  componentWillMount(){
    this.props.findAllArticle(0)
  }

  render(){
    const {push} = this.props
    const {list, totalPages, page} = this.props.article
    const articleList = list.map(article => {
      return (
        <Article
          key={article.id}
          title={article.title}
          body={article.body}
          author={article.author}
          tags={article.tags}
          push={push}
          />)
    })
    return (
      <div>
        {articleList}
      </div>
    )
  }
}

function mapStateToProps(state){
  return state;
}

export default connect(
  mapStateToProps, {
      findAllArticle,
      push: routeActions.push
  }
)(ArticleList)
