package com.complete.registration.dto;




public record RegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String role) {
}
