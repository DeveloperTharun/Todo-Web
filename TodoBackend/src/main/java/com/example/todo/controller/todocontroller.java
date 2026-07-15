package com.example.todo.controller;

import com.example.todo.model.todo;
import com.example.todo.service.todoservice;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/todo")
public class todocontroller {
    @Autowired
    private todoservice todoservice;

    @GetMapping
    ResponseEntity<List<todo>> getalltodos(){
        return new ResponseEntity<List<todo>>(todoservice.getalltodos(), HttpStatus.OK);
    }

    @GetMapping("/page")
    ResponseEntity<Page<todo>> getalltodosbypage(@RequestParam int page,@RequestParam int size){
        return new ResponseEntity<Page<todo>>(todoservice.getalltodosbypage(page, size), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "todo retrived successfully!"),
            @ApiResponse(responseCode = "404", description = "todo not found!")
    })
    @GetMapping("/{id}")
    ResponseEntity<todo> getbyid(@PathVariable Long id){
        try {
            return new ResponseEntity<>(todoservice.getbyid((id)), HttpStatus.OK);
        } catch(RuntimeException e){
            log.info("id found");
            log.warn(" ");
            log.error("ID not found", e);
            return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    ResponseEntity<todo> create(@RequestBody todo Todo){
        return new ResponseEntity<>(todoservice.createtodo(Todo), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    ResponseEntity<todo> updatetodo(@RequestBody todo todo){
        return new ResponseEntity<todo>(todoservice.updatetodo(todo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deletetodo(@PathVariable Long id){
        todoservice.deletetodo(id);
    }


}
