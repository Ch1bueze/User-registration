package com.complete.registration.dto;

import com.complete.registration.entity.UserRole;
import lombok.Data;


public record RegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        UserRole role) {
}
