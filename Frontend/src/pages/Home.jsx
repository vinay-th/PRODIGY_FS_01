import React from 'react';
import { Link } from 'react-router-dom';

function Home() {
  return (
    <div className="home">
      <h1>Welcome to AuthFlow</h1>
      <p>
        A demo authentication system with secure login and registration
        functionality.
      </p>
      <div className="cta-buttons">
        <Link to="/login" className="btn btn-primary">
          Login
        </Link>
        <Link to="/register" className="btn btn-secondary">
          Register
        </Link>
      </div>
    </div>
  );
}

export default Home;
