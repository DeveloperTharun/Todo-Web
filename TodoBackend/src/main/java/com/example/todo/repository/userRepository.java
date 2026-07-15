package com.example.todo.repository;

import com.example.todo.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  userRepository extends JpaRepository<user, Long> {
    Optional<user> findByEmail(String email);
}
