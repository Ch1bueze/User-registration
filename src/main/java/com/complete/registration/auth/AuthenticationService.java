package com.complete.registration.auth;

import com.complete.registration.dto.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public String register(RegistrationRequest request){
        return "works";
    }
}
