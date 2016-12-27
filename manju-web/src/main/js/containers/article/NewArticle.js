import React, { Component, PropTypes } from 'react'
import { connect } from 'react-redux'
import { routeActions } from 'react-router-redux'
import Card from 'material-ui/lib/card/card'
import CardActions from 'material-ui/lib/card/card-actions'
import CardText from 'material-ui/lib/card/card-text'
import TextField from 'material-ui/lib/text-field'
import RaisedButton from 'material-ui/lib/raised-button'
import FlatButton from 'material-ui/lib/flat-button'
import RadioButton from 'material-ui/lib/radio-button'
import marked from 'marked'
import { registerArticle } from '../../actions/articleAction'

class NewArticle extends Component {
  constructor(props){
    super(props)
    this.handleUpdate = this.handleUpdate.bind(this)
    this.handleCancel = this.handleCancel.bind(this)
    this.handleBodyChange = this.handleBodyChange.bind(this)
    this.state = {
      disabled: false,
      message: ''
    }
  }
  componentWillReceiveProps(nextProps) {
    this.setState({
      disabled: nextProps.updateSuccess === undefined
    })
  }

  handleBodyChange(){
      this.setState({
        message: marked(this.refs.body.getValue())
      })
  }

  handleUpdate(){
    this.setState({
      disabled: false
    })


    const title = this.refs.title.getValue()
    const tags = this.refs.tags.getValue().split(',')
    const body = this.refs.body.getValue()
    
    this.props.registerArticle({
      title: title,
      body: body,
      tags: tags,
      publicationTarget: 'ALL'.split(','),
      status: 'PUBLISHED'
    })
  }

  handleCancel(){
    this.props.push(`/article`)
  }

  render(){
    return (
      <div>
        <Card style={{marginTop: '16px', marginRight: '16px'}}>
          <CardText >
            <TextField
              style={{width: '100%'}}
              ref="title"
              floatingLabelText="タイトル" />
            <TextField
              style={{width: '100%'}}
              ref="tags"
              floatingLabelText="タグ(カンマ区切り)" />
            <TextField
              style={{width: '100%'}}
              ref="body"
              rows={3}
              multiLine={true}
              onChange={this.handleBodyChange}
              floatingLabelText="本文" />
          <div dangerouslySetInnerHTML={{__html: this.state.message}} />
          </CardText>
          <CardActions style={{ display: 'table', marginLeft: 'auto', marginRight: '0px' }} >
            <FlatButton
              label="戻る"
              onTouchTap={this.handleCancel}
            />
            <RaisedButton
              label="登録"
              primary={true}
              disabled={this.state.disabled}
              onTouchTap={this.handleUpdate}
            />
          </CardActions>
        </Card>
      </div>
    )
  }
}
function mapStateToProps(state){
  return state;
}
console.log(registerArticle)
export default connect(
  mapStateToProps, {
      registerArticle,
      push: routeActions.push
  }
)(NewArticle)
