package com.complete.registration.dto;

import lombok.Data;


public record RegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password) {
}
