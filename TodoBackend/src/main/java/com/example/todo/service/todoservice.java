package com.example.todo.service;

import com.example.todo.model.todo;
import com.example.todo.repository.todoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class todoservice {
    @Autowired
    private todoRepository todoRepository;

    public todo createtodo(todo Todo){
        return todoRepository.save(Todo);
    }

    public todo getbyid(Long id){
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("todo not found"));
    }

    public Page<todo> getalltodosbypage(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return todoRepository.findAll(pageable);
    }

    public List<todo> getalltodos(){
        return todoRepository.findAll();
    }

    public todo updatetodo(todo Todo){
        return todoRepository.save(Todo);
    }

    public void deletetodo(Long id){
        todoRepository.delete(getbyid(id));
    }
}
