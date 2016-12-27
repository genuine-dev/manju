import React, { Component, PropTypes } from 'react'
import { connect } from 'react-redux'
import { routeActions } from 'react-router-redux'
import injectTapEventPlugin from 'react-tap-event-plugin'
import AppBar from 'material-ui/lib/app-bar';
import RaisedButton from 'material-ui/lib/raised-button'
import { loadMe, registerUser } from '../actions/userAction'



injectTapEventPlugin();

class App extends Component {
  constructor(props){
     super(props)
     this.handleRegisterUser = this.handleRegisterUser.bind(this)
     this.handleMe = this.handleMe.bind(this)
  }

  handleMe(){
    this.props.loadMe()
  }


  handleRegisterUser(){
    this.props.registerUser()
  }

  render() {
    const { children, routing, user, push } = this.props

    return (
      <div>
        <AppBar title='MANJU' showMenuIconButton={false}/>
        {user.me === null &&
          <div>
          <RaisedButton label="ログイン" href="/login" linkButton={true} />
          <RaisedButton label="ユーザー登録" onTouchTap={this.handleRegisterUser}  />
          <RaisedButton label="ユーザー取得" onTouchTap={this.handleMe}  />
          </div>
        }
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
    loadMe,
    registerUser,
  }
)(App)
