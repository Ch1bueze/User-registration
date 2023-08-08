package com.complete.registration.service.impl;

import com.complete.registration.dto.RegistrationRequest;
import com.complete.registration.entity.AppUser;
import com.complete.registration.entity.RegistrationToken;

import com.complete.registration.exception.UserAlreadyExistsException;
import com.complete.registration.repository.TokenRepository;
import com.complete.registration.repository.UserRepository;
import com.complete.registration.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final static String USER_NOT_FOUND_MSG = "User with email %s not found";
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    @Override
    public AppUser register(RegistrationRequest request) {
        Optional<AppUser> user = userRepository.findByEmail(request.email());
        if (user.isPresent()){
            throw new UserAlreadyExistsException("user with email " + request.email() + " is already registered");
        }
        var newUser = new AppUser();
        newUser.setUserRole(request.role());
        newUser.setEmail(request.email());
        newUser.setPassword(passwordEncoder.encode(request.password()));
        newUser.setFirstName(request.firstName());
        newUser.setLastName(request.lastName());

        return userRepository.save(newUser);
    }

    @Override
    public Optional<AppUser> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<AppUser> GetAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUserVerificationToken(AppUser user, String verificationToken) {
        var registrationToken = new RegistrationToken(user, verificationToken);
        tokenRepository.save(registrationToken);
    }
}
