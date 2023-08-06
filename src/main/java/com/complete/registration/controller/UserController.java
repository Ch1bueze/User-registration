package com.complete.registration.controller;

import com.complete.registration.dto.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {
    @PostMapping
    public String register(RegistrationRequest request){
        return "works";
    }
}
