package com.example.todo.controller;

import com.example.todo.model.user;
import com.example.todo.repository.userRepository;
import com.example.todo.service.userservice;
import com.example.todo.utils.jwtutil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthUser {
    private final userRepository userRepository;
    private final userservice userservice;
    private final PasswordEncoder PasswordEncoder;
    private final jwtutil jwtutil;

    @PostMapping("/register")
    public ResponseEntity<String> registeruser(@RequestBody Map<String, String> body){
        String email = body.get("email");
        String password=PasswordEncoder.encode(body.get("password"));

        if(userRepository.findByEmail(email).isPresent()){
            return new ResponseEntity<>("Email alredy Exist!", HttpStatus.CONFLICT);
        }
        userservice.createUser(user.builder().email(email).password(password).build());
        return new ResponseEntity<>("Successfully Created!!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginuser(@RequestBody Map<String, String> body){
        String email=body.get("email");
        String password=body.get("password");

        if(userRepository.findByEmail(email).isEmpty()){
            return new ResponseEntity<>("User Not Found!", HttpStatus.UNAUTHORIZED);
        }
        user User= userRepository.findByEmail(email).get();
        if(!PasswordEncoder.matches(password, User.getPassword())){
            return new ResponseEntity<>("Password incorrect!", HttpStatus.NOT_FOUND);
        }
        String token=jwtutil.generateToken(email);
        System.out.println("Generated Token: " + token);
        return ResponseEntity.ok(Map.of("token", token));
    }
}
