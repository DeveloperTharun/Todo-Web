package com.example.todo.service;

import com.example.todo.model.user;
import com.example.todo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userservice {
    @Autowired
    private userRepository userRepository;

    public user createUser(user User){
        return userRepository.save(User);
    }

    public user getuserbyid(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
    }

}
