import React from 'react'
import './Nav.css'
import logo from '../../assets/atom.svg'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import SignIn from '../sign-in/SignIn';



const Navbar = () =>
  <nav className="">
    <div class="inline logo">
      <a>
        <img src={ logo }></img>
      </a>
    </div>
    <div class="inline navbar__content">
      <a href="#">
        Home
      </a>
      <a href="#">
        Car Catalog
      </a>
      <a href="#">
        Contacts
      </a>
      <a href="#">
        Support
      </a>
      <Link to="/signin">Sign in</Link>
    </div>
  </nav>


export default Navbar