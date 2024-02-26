package com.warsen.artWeb.repository;

import com.warsen.artWeb.model.entity.Role;
import com.warsen.artWeb.security.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String role);
}
