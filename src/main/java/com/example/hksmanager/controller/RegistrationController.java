package com.example.hksmanager.controller;

import com.example.hksmanager.component.Registration;
import com.example.hksmanager.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/registrations")
public class RegistrationController {


    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/add")
    public ResponseEntity<Registration> addRegistration(@RequestBody Registration registration) {
        Registration newRegistration = registrationService.addRegistration(registration);
        return new ResponseEntity<>(newRegistration, HttpStatus.CREATED);
    }




}
