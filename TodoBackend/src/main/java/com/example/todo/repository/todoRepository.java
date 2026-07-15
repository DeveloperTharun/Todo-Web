package com.example.todo.repository;


import com.example.todo.model.todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface todoRepository extends JpaRepository<todo, Long> {

}
