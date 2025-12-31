import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar";
import {
  getEmployees,
  deleteEmployee,
} from "../services/employeeService";

function Employees({ employees, setEmployees }) {
  const navigate = useNavigate();

  // Load employees on page load
  useEffect(() => {
    getEmployees()
      .then((res) => setEmployees(res.data))
      .catch(() => alert("Failed to load employees"));
  }, []);

  const handleDelete = (id) => {
    deleteEmployee(id)
      .then(() => {
        setEmployees(employees.filter((emp) => emp.id !== id));
      })
      .catch(() => alert("Delete failed"));
  };

  return (
    <div>
      <Navbar />

      <div className="page-container">
        <h2>Employees</h2>

        {employees.map((emp) => (
          <div key={emp.id} className="employee-item">
            <span>
              {emp.firstName} {emp.lastName} – {emp.email}
            </span>

            <div>
              <button
                className="btn btn-warning btn-sm"
                onClick={() => navigate(`/edit/${emp.id}`)}
              >
                Edit
              </button>

              <button
                className="btn btn-danger btn-sm"
                onClick={() => handleDelete(emp.id)}
              >
                Delete
              </button>
            </div>
          </div>
        ))}

        <button
          className="btn btn-primary mt-3"
          onClick={() => navigate("/add")}
        >
          + Add Employee
        </button>
      </div>
    </div>
  );
}

export default Employees;





