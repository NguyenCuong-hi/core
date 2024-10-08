package com.example.core.repository;

import com.example.core.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthenticationRepository extends JpaRepository<Token, UUID> {
}
