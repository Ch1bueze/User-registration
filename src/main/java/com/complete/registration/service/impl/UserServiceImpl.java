package com.complete.registration.service.impl;

import com.complete.registration.dto.RegistrationRequest;
import com.complete.registration.entity.AppUser;
import com.complete.registration.repository.UserRepository;
import com.complete.registration.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final static String USER_NOT_FOUND_MSG = "User with email %s not found";
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    @Override
    public AppUser register(RegistrationRequest request) {
        return null;
    }

    @Override
    public Optional<AppUser> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<AppUser> GetAllUsers() {
        return userRepository.findAll();
    }
}
