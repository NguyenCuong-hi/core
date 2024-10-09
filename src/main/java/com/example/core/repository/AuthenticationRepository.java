package com.example.core.repository;

import com.example.core.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AuthenticationRepository extends JpaRepository<Token, UUID> {
}
