import React from 'react'
import './Header.css'
import header from './assets/header.jpg'
const Header = () =>
<div>
    
        <div className="header">
            <img className="header_image" src={ header }></img>
            <div className="image_overlay"></div>
            <div className="text">
                <h3>Аренда автомобилей в городе Алматы</h3>
                <p></p>
                <button className="btn">
                   Начать подбор автомобиля  
                 </button>
             </div>

        </div>
</div>
export default Header
