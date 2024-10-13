package com.pregunta2.users.services;

import com.pregunta2.users.entities.User;
import com.pregunta2.users.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Evita que se modifique nada de Repository desde esta clase
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(String email, String password){
        if (userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("El email ya existe.");
        }

        User user = new User(email, password);
        return userRepository.save(user);
    }
}