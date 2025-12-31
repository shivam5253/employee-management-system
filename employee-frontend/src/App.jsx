import { Routes, Route } from "react-router-dom";
import { useState } from "react";

import Login from "./pages/Login";
import Employees from "./pages/Employees";
import AddEmployee from "./pages/AddEmployee";
import EditEmployee from "./pages/EditEmployee";
import ProtectedRoute from "./routes/ProtectedRoute";
import Signup from "./pages/Signup";

function App() {
  //  Central employees state
  const [employees, setEmployees] = useState([]);

  return (
    <Routes>
      <Route path="/" element={<Login />} />

      <Route  path="/employees"
        element={<ProtectedRoute><Employees employees={employees} setEmployees={setEmployees} />
      </ProtectedRoute>}
      />

      <Route
        path="/add"
        element={<ProtectedRoute><AddEmployee employees={employees} setEmployees={setEmployees} /></ProtectedRoute>}
      />

      <Route
        path="/edit/:id"
        element={<ProtectedRoute><EditEmployee employees={employees} setEmployees={setEmployees} /></ProtectedRoute>}
      />
      <Route path="/signup" element={<Signup/>}/>
    </Routes>
  );
}

export default App;





