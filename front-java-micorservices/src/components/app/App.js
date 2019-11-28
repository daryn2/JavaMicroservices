import React from 'react';
import CarList from '../car-list/Car-list';
import logo from '../../logo.svg';
import './App.css';
import Navbar from '../nav/Nav';
import Header from '../header/Header';
import AuthProvider from '../../AuthProvider';
import Main from '../main-page/Main'
import SignIn from '../sign-in/SignIn'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
function App() {
  return (
    <Router>
    
    <Switch>
    <Route exact path="/" component={Main}>
      </Route>
      <Route exact path="/signin" component={SignIn}>
      </Route>
    </Switch>
  </Router>
  );
}

export default App;
