import React from 'react';
import CarList from '../car-list/Car-list';
import logo from '../../logo.svg';

import Header from '../header/Header';
import AuthProvider from '../../AuthProvider';
import './Main.css'

const Main = () => {
  return (
    <div className="Main">
      <AuthProvider></AuthProvider>
      {/* <Navbar></Navbar> */}
      <Header></Header>
      <CarList></CarList>
    </div>
  );
}

export default Main;
