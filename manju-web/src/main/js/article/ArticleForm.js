import React, { Component, PropTypes } from 'react'
import Card from 'material-ui/lib/card/card'
import TextField from 'material-ui/lib/text-field'
import RaisedButton from 'material-ui/lib/raised-button'

export default class ArticleForm extends Component {
  render(){
    return (
      <div>
        <Card>
        <TextField hintText="タイトル" ref="title" fullWidth={true}/>
        <TextField hintText="タグ" ref="tags" fullWidth={true}/>
        <TextField hintText="本文" ref="body" fullWidth={true} multiLine={true} rows={20} />

        </Card>
      </div>
    )
  }
}
