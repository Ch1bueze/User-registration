package com.complete.registration.event.listener;

import com.complete.registration.entity.AppUser;
import com.complete.registration.event.RegistrationEvent;
import com.complete.registration.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationEventListener implements ApplicationListener<RegistrationEvent> {
    private final UserService userService;
    @Override
    public void onApplicationEvent(RegistrationEvent event) {
        AppUser user = event.getAppUser();
        String verificationToken = UUID.randomUUID().toString();

        userService.saveUserVerificationToken(user, verificationToken);

        String url = event.getApplicationUrl() + "/register/verifyEmail?token="+verificationToken;
        log.info("Click the link to verify registration: {}", url);
    }
}
