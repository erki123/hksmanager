package com.example.hksmanager.repository;

import com.example.hksmanager.component.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
