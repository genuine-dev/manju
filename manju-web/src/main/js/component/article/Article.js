import React, { Component, PropTypes } from 'react'
import Card from 'material-ui/lib/card/card'
import CardText from 'material-ui/lib/card/card-text'
import CardHeader from 'material-ui/lib/card/card-header'
import Tag from './Tag'
import marked from 'marked'

export default class Article extends Component {
  render(){
    const {title, body, tags, author, push} = this.props
    const tagButtons = tags.map(tag => {
      return <Tag tag={tag} style={{float: 'right'}} push={push}/>
    })
    return (
      <Card>
        <CardHeader
          title={title}
          subtitle=""
          actAsExpander={false}
          showExpandableButton={true}
        >
        <div>
        {tagButtons}
        </div>
        </CardHeader>
        <CardText expandable={true}>
          <div dangerouslySetInnerHTML={{__html: marked(body)}} />
        </CardText>
      </Card>
    )
  }
}
