package com.example.employee_backend.service;

import com.example.employee_backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    // CREATE
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    // READ ALL

    List<EmployeeDto> getAllEmployees();

    // READ BY ID
    EmployeeDto getEmployeeById(Long id);

    // UPDATE
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

    // DELETE
    void deleteEmployee(Long id);
}
