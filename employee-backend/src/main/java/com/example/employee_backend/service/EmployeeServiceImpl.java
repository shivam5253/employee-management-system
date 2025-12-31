package com.example.employee_backend.service;

import com.example.employee_backend.dto.EmployeeDto;
import com.example.employee_backend.entity.Employee;
import com.example.employee_backend.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    // Repository for database operations
    private final EmployeeRepository employeeRepository;

    // Used to convert DTO <-> Entity
    private final ModelMapper modelMapper;

    // EXPLICIT constructor (no Lombok)
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    // Create a new employee
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        // Convert incoming DTO to entity
        Employee employee = modelMapper.map(employeeDto, Employee.class);

        // Save entity to database
        Employee savedEmployee = employeeRepository.save(employee);

        // Convert saved entity back to DTO
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    // Fetch all employees
    @Override
    public List<EmployeeDto> getAllEmployees() {

        // Get all employee entities, convert each to DTO, collect into list
        return employeeRepository.findAll()
                .stream()
                .map(emp -> modelMapper.map(emp, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    // Fetch single employee by id
    @Override
    public EmployeeDto getEmployeeById(Long id) {

        // Find employee or throw exception if not found
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id: " + id));

        // Convert entity to DTO
        return modelMapper.map(employee, EmployeeDto.class);
    }

    // Update existing employee
    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {

        // Fetch existing employee
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id: " + id));

        // Update fields
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        // Save updated employee
        Employee updatedEmployee = employeeRepository.save(employee);

        // Convert updated entity to DTO
        return modelMapper.map(updatedEmployee, EmployeeDto.class);
    }

    // Delete employee by id
    @Override
    public void deleteEmployee(Long id) {
        // Delete record from database
        employeeRepository.deleteById(id);
    }
}

