import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar";
import { addEmployee } from "../services/employeeService";

function AddEmployee() {
  const navigate = useNavigate();

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    addEmployee({ firstName, lastName, email })
      .then(() => navigate("/employees"))
      .catch(() => alert("Failed to add employee"));
  };

  return (
    <div>
      <Navbar />

      <div className="page-container">
        <h2>Add Employee</h2>

        <form onSubmit={handleSubmit}>
          <input className="form-control mb-3" placeholder="First Name"
            onChange={(e) => setFirstName(e.target.value)} />

          <input className="form-control mb-3" placeholder="Last Name"
            onChange={(e) => setLastName(e.target.value)} />

          <input className="form-control mb-3" placeholder="Email"
            onChange={(e) => setEmail(e.target.value)} />

          <button className="btn btn-primary w-100">Save</button>
        </form>
      </div>
    </div>
  );
}

export default AddEmployee;



