import React, { Component, PropTypes } from 'react'
import { connect } from 'react-redux'
import { routeActions } from 'react-router-redux'
import TextField from 'material-ui/lib/text-field'
import RaisedButton from 'material-ui/lib/raised-button'
import { findArticleByKeyword } from '../actions/articleAction'


class Article extends Component {
  constructor(props){
     super(props)
     this.handleRegister = this.handleRegister.bind(this)
     this.handleList = this.handleList.bind(this)
     this.handleSearch = this.handleSearch.bind(this)
  }

  handleRegister(){
    this.props.push('/article/new')
  }

  handleList(){
    this.props.push('/article/list')
  }

  handleSearch(){
    const keyword = this.refs.keyword.getValue()
    this.props.findArticleByKeyword(keyword, 0)
  }

  render() {
    const { children, routing, user} = this.props

    return (
      <div>
        <RaisedButton label="登録" onTouchTap={this.handleRegister }/>
        <RaisedButton label="一覧" onTouchTap={this.handleList }/>
        <TextField ref="keyword" floatingLabelText="キーワード"/>
        <RaisedButton label="検索" onTouchTap={this.handleSearch }/>
        {children}
      </div>
    )
  }
}

function mapStateToProps(state){
  return state;
}

export default connect(
  mapStateToProps, {
    findArticleByKeyword,
    push: routeActions.push
  }
)(Article)
