package com.complete.registration.dto;

import lombok.Data;

@Data
public record RegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password) {
}
