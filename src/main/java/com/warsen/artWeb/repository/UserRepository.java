package com.warsen.artWeb.repository;

import com.warsen.artWeb.model.User;
import com.warsen.artWeb.security.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findByRoles_Name(UserRole roleName);
    Optional<User> findByEmail(String email);
}
