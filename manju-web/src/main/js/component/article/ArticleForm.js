import React, { Component, PropTypes } from 'react'
import Card from 'material-ui/lib/card/card'
import TextField from 'material-ui/lib/text-field'
import RaisedButton from 'material-ui/lib/raised-button'

export default class ArticleForm extends Component {
  render(){
    return (
      <div>
        <Card>
        <TextField hintText="Title" ref="title" style={{width: '100%'}}/>

        </Card>
      </div>
    )
  }
}
