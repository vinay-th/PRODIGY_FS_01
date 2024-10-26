import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Dashboard() {
  const [user, setUser] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    // Here you would typically check if the user is authenticated
    // For demo purposes, we'll just simulate a logged-in user
    const simulateAuthCheck = () => {
      const isLoggedIn = localStorage.getItem('isLoggedIn');
      if (!isLoggedIn) {
        navigate('/login');
      } else {
        setUser({ name: 'John Doe', email: 'john@example.com' });
      }
    };

    simulateAuthCheck();
  }, [navigate]);

  const handleLogout = () => {
    // Here you would typically clear the user's session
    localStorage.removeItem('isLoggedIn');
    navigate('/login');
  };

  if (!user) {
    return <div>Loading...</div>;
  }

  return (
    <div className="dashboard">
      <h1>Welcome, {user.name}!</h1>
      <p>Email: {user.email}</p>
      <button onClick={handleLogout} className="btn btn-primary">
        Logout
      </button>
    </div>
  );
}

export default Dashboard;
