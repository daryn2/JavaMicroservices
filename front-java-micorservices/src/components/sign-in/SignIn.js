import React, { Component } from 'react'
import * as constants from '../../constants/request-constants'
import signin from '../../assets/signin2.jpg'
import './SignIn.css'
class SignIn extends React.Component {
    constructor() {
        super()
        this.state = {
            formControls: {
                username: {
                    value: ''
                },
                password: {
                    value: ''
                }
            }
        }
        this.handleChange = this.handleChange.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this)
        
    }
    handleChange(event) {
        const name = event.target.name
        const value = event.target.value
        this.setState({
            formControls: {
                ...this.state.formControls,
                [name] : {
                    ...this.state.formControls[name],
                    value
                }
            }
        })
    }
    handleSubmit(event) {
        alert('имя '  + this.state.formControls.username.value)
        alert('пароль '  + this.state.formControls.password.value)

        event.preventDefault();
    }
    render() {
        return (
            <div className="signin">
                <img className="sign-in__image" src={ signin }/>
                <div className="sign-in__content">
                    {/* <hr/> */}
                    <div className="sign_in__content__form">
                        <h1>Sign in</h1>

                        <form onSubmit={this.handleSubmit}>
                            <input placeholder=" Name" type="text"  name = "username" value= {this.state.formControls.username.value} onChange = {this.handleChange} />
                            <input placeholder=" Password" type="text" name="password" value = { this.state.formControls.password.value } onChange = { this.handleChange }/>
                            <button className="btn">Sign in</button>
                        </form>
                        <a href="#">Create an account</a>
                    </div>
                        
                    
                </div>
            </div>
        )
    }
}
export default SignIn