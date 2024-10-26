import React from 'react';
import Logo from '../assets/Logo.svg';
import { Link } from 'react-router-dom';

function Header() {
  return (
    <header className="header">
      <nav>
        <Link to="/" className="logo">
          <img
            src={Logo}
            alt="Logo"
            style={{ height: '100px', width: '100px' }}
          />
        </Link>
        <div className="nav-links">
          <Link to="/login">Login</Link>
          <Link to="/register">Register</Link>
        </div>
      </nav>
    </header>
  );
}

export default Header;
