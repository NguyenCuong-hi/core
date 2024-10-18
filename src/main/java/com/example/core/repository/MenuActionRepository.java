package com.example.core.repository;

import com.example.core.entity.MenuAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuActionRepository extends JpaRepository<MenuAction, Long> {
}
