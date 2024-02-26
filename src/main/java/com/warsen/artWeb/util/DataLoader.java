package com.warsen.artWeb.util;

import com.warsen.artWeb.model.entity.Role;
import com.warsen.artWeb.repository.RoleRepository;
import com.warsen.artWeb.security.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;

public class DataLoader implements ApplicationRunner {

    private final RoleRepository roleRepository;

    @Autowired
    public DataLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        roleRepository.save(new Role(UserRole.ROLE_USER.name()));
        roleRepository.save(new Role(UserRole.ROLE_ADMIN.name()));
        roleRepository.save(new Role(UserRole.ROLE_ARTIST.name()));

    }
}
