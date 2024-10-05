package com.example.core.repository;

import com.example.core.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

//    Boolean isExitsBy(Set<Role> roles);
}
