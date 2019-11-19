import React, { Component } from 'react'
import * as constants from './constants/request-constants'
import axios from 'axios'
import './Car-list.css'
import car1 from './assets/1.jpg'

class CarList extends React.Component {
    // send request to the server
    constructor() {
        super()
         this.state = {
            data:[]
        }
    }
    componentDidMount() {
        console.log("hello")
        this.fetchData()
    }
    // send request to the server
    async fetchData() {


        var url = constants.get_cars
        const token = localStorage.token;

       
        const AuthStr = 'Bearer '.concat(token); 

        axios.get(url, { headers: { Authorization: AuthStr }, withCredentials:true })
        .then(response => {
            console.log(response.data);
            this.setState({
                data: response.data
            })
         })
        .catch((error) => {
            console.log('error ' + error);
         });            
        // fetch(url, {
        //     method:'GET',
        //     headers: {
        //         'Content-Type': 'application/json',
        //         Accept: 'application/json',
        //         'Authorization': `Bearer ${token}`
        //       }
        // }).then(function(response) {
        //     console.log(response)
            // this.setState({
            //     data: response.data
            // })
        // })
        
        
    }

    render() {
        let data = this.state.data
    
        const result = data.map((entry, index) => {
            return (
                <div className="col-md-6" key={index}>
                    <div className="car-list__image">
                        <img src= { entry.url } width="100%"/>
                    </div>
                    <div className="car-list_description">
                        <h5>{ entry.brand }</h5>
                        <div className="ratings">
                            <span className="fa fa-star checked"></span>
                            <span className="fa fa-star checked"></span>
                            <span className="fa fa-star checked"></span>
                            <span className="fa fa-star"></span>
                            <span className="fa fa-star"></span>
                        </div>
                        <h6> Last reviews: </h6>
                        { entry.reviews.map((answer, i) => {
                            return (
                                <div key={i}>
                                    <p> {answer} </p>
                                </div>
                            )
                        }) }
                    </div>
                </div>
        
            )
        })

        return (
            <div className="car-list">
                <div className="container">
                    <h2> Our best options </h2>
                    <div className="row">
                       { result }
                    </div>
                    <div className="empty_space">

                    </div>
                </div>
            </div>
        )
    }
}
export default CarList
