package com.complete.registration.repository;

import com.complete.registration.entity.RegistrationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<RegistrationToken, Long> {
}
