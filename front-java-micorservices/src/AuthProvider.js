import React, { Component } from 'react'
import * as constants from './constants/request-constants'
import axios from 'axios'
class AuthProvider extends React.Component {
    token = localStorage.getItem('token');
    constructor() {
        super()
        console.log(this.token)
    }
    componentDidMount() {
            this.fetchToken()
        
    }
    async fetchToken() {
        var username = "admin"
        var password = "12345"
        axios.post("http://localhost:8762/auth/", {
            username,
            password
        })
        .then(function(response) {
            localStorage.setItem("token", response.data)
            console.log(response.data);
            console.log("there")
        });

       
        
    }
    render() {
        return <div></div>
    }
    
    
}
export default AuthProvider