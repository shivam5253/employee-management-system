package com.example.employee_backend.repository;

import com.example.employee_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


//Repository is the only layer that talks to DataBase
//Without writing SQL, you now have:
//Method	SQL equivalent
//save()	INSERT / UPDATE
//findAll()	SELECT *
//findById()	SELECT by ID
//deleteById()	DELETE
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
