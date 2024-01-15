package com.warsen.artWeb.controller;

import com.warsen.artWeb.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user/registration")
public class RegistrationController {

    @PostMapping
    public ResponseEntity<String> processRegistration(@RequestBody @Valid UserDto user,
                                                      BindingResult result,
                                                      HttpServletRequest request,
                                                      Errors errors) {

        return null;
    }

}
