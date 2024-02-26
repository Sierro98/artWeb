package com.warsen.artWeb.repository;

import com.warsen.artWeb.model.entity.User;
import com.warsen.artWeb.security.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findByRoles_Name(UserRole roleName);
    Optional<User> findByEmail(String email);
}
