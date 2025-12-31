import { useNavigate } from "react-router-dom";

function Navbar() {
  const navigate = useNavigate();

  // Called when Logout button is clicked
  const handleLogout = () => {
    localStorage.removeItem("isLoggedIn");
    navigate("/");
  };

  return (
    <nav className="navbar navbar-dark bg-dark px-3">
      {/* App Name / Brand */}
      <span className="navbar-brand">
        Employee Management
      </span>

      {/* Logout Button */}
      <button
        className="btn btn-outline-light"
        onClick={handleLogout}
      >
        Logout
      </button>
    </nav>
  );
}

export default Navbar;
