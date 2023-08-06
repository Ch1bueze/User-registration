package com.complete.registration.service;


import com.complete.registration.dto.RegistrationRequest;
import com.complete.registration.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    AppUser register(RegistrationRequest request);
    Optional<AppUser> getUserByEmail(String email);
    List<AppUser> GetAllUsers();

}
