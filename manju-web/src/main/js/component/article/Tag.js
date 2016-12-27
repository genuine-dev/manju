import React, { Component, PropTypes } from 'react'
import FlatButton from 'material-ui/lib/flat-button'

export default class Tag extends Component {
  constructor(props){
    super(props)
    this.handleTag = this.handleTag.bind(this)
  }

  handleTag(){
    const { tag } = this.props
    this.props.push(`/article/tag/${tag}`)
  }

  render(){
    const { tag, style } = this.props
    return (<FlatButton label={tag} primary={true} style={style} onTouchTap={this.handleTag}/>)
  }
}
