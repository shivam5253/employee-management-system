import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { login } from "../services/authService";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await login({
        email: email,
        password: password,
      });

      // Save JWT token
      localStorage.setItem("token", response.data.token);

      // Redirect after login
      navigate("/employees");

    } catch (error) {
      alert("Invalid email or password");
    }
  };

  return (
    <div className="page-container">
      <h2>Login</h2>

      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label>Email</label>
          <input
            className="form-control"
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>

        <div className="mb-3">
          <label>Password</label>
          <input
            className="form-control"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>

        <button className="btn btn-primary w-100">
          Login
        </button>
      </form>

      <p style={{ marginTop: "10px" }}>
  Don’t have an account?{" "}
  <span
    style={{ color: "blue", cursor: "pointer" }}
    onClick={() => navigate("/signup")}
  >
    Signup
  </span>
</p>

    </div>
  );
}

export default Login;
