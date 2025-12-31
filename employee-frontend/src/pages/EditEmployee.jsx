import { useParams, useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import Navbar from "../components/Navbar";
import {
  getEmployees,
  updateEmployee,
} from "../services/employeeService";

function EditEmployee() {
  const { id } = useParams();
  const navigate = useNavigate();

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");

  useEffect(() => {
    getEmployees().then((res) => {
      const emp = res.data.find(e => e.id === Number(id));
      setFirstName(emp.firstName);
      setLastName(emp.lastName);
      setEmail(emp.email);
    });
  }, []);

  const handleUpdate = (e) => {
    e.preventDefault();

    updateEmployee(id, { firstName, lastName, email })
      .then(() => navigate("/employees"))
      .catch(() => alert("Update failed"));
  };

  return (
    <div>
      <Navbar />

      <div className="page-container">
        <h2>Edit Employee</h2>

        <form onSubmit={handleUpdate}>
          <input className="form-control mb-3"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)} />

          <input className="form-control mb-3"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)} />

          <input className="form-control mb-3"
            value={email}
            onChange={(e) => setEmail(e.target.value)} />

          <button className="btn btn-warning w-100">Update</button>
        </form>
      </div>
    </div>
  );
}

export default EditEmployee;



