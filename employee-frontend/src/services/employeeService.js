import api from "./api";

// Get all employees
export const getEmployees = () => {
  return api.get("/api/employees");
};

// Add employee
export const addEmployee = (employee) => {
  return api.post("/api/employees", employee);
};

// Update employee
export const updateEmployee = (id, employee) => {
  return api.put(`/api/employees/${id}`, employee);
};

// Delete employee
export const deleteEmployee = (id) => {
  return api.delete(`/api/employees/${id}`);
};

