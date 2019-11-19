import React from 'react';
import CarList from './Car-list';
import logo from './logo.svg';
import './App.css';
import Navbar from './Nav';
import Header from './Header';
import AuthProvider from './AuthProvider';

function App() {
  return (
    <div className="App">
      <AuthProvider></AuthProvider>
      <Navbar></Navbar>
      <Header></Header>
      <CarList></CarList>
    </div>
  );
}

export default App;
