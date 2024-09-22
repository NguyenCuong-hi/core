package com.example.core.repository;

import com.example.core.entity.User;
import liquibase.license.LicenseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getById(Long id);

    List<User> getAllBy();
}
