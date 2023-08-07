package com.complete.registration.controller;

import com.complete.registration.dto.RegistrationRequest;
import com.complete.registration.entity.AppUser;
import com.complete.registration.event.RegistrationEvent;
import com.complete.registration.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ApplicationEventPublisher publisher;
    @PostMapping
    public ResponseEntity<AppUser> register(RegistrationRequest registrationRequest, HttpServletRequest request){
        AppUser user = userService.register(registrationRequest);
        publisher.publishEvent(new RegistrationEvent(user, applicationUrl(request)));
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    public String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
