import React from 'react'
import './Header.css'
import header from '../../assets/header3.jpg'
import arrow from '../../assets/arrow.png'

import Navbar from '../nav/Nav';

const Header = () =>
<div>
    
        <div className="header">
        <Navbar></Navbar>

            <img className="header_image" src={ header }></img>
            <div className="text">
                <h1>Аренда машин</h1>
                <a className="btn">
                   Каталог
                 </a>
                 <a className="btn">
                   Отзывы
                 </a>
                 
             </div>
             <img class="arrow" src={ arrow } />

        </div>
</div>
export default Header
