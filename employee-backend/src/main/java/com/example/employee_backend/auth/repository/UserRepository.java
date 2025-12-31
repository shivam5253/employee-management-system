package com.example.employee_backend.auth.repository;
import com.example.employee_backend.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {

    //Check if user already exists (signup)
    Optional<User> findByEmail(String email);


    //Fetch user by email (login)
    boolean existsByEmail(String email);

}
