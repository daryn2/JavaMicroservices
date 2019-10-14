import React from 'react';
import CarList from './Car-list';
import logo from './logo.svg';
import './App.css';
import Navbar from './Nav';
import Header from './Header';

function App() {
  return (
    <div className="App">
      <Navbar></Navbar>
      <Header></Header>
      <CarList></CarList>
    </div>
  );
}

export default App;
