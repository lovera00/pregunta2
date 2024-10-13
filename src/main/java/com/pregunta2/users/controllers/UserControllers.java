package com.pregunta2.users.controllers;

import com.pregunta2.users.dtos.RegisterUserDto;
import com.pregunta2.users.repositories.UserRepository;
import com.pregunta2.users.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllers {

    // Evita que se modifique nada de Service desde esta clase
    private final UserService userService;

    public UserControllers(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterUserDto registerUserDto){
        userService.registerUser(registerUserDto.getEmail(), registerUserDto.getPassword());
        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }
}
