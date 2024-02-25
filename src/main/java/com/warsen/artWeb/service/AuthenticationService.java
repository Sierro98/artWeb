package com.warsen.artWeb.service;

import com.warsen.artWeb.controller.response.AuthenticationResponse;
import com.warsen.artWeb.dto.UserDto;
import com.warsen.artWeb.model.entity.User;
import com.warsen.artWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository repository;

    @Autowired
    public AuthenticationService(UserRepository repository) {
        this.repository = repository;
    }

    public AuthenticationResponse register(UserDto request) {
        var user = new User();
                user.setUsername(request.getUsername());
                user.setPassword(request.getPassword());
                user.setEmail(request.getEmail());
        return null;
    }

    public AuthenticationResponse authenticate(UserDto request) {
        return null;
    }
}
