package com.warsen.artWeb.service;

import com.warsen.artWeb.controller.response.AuthenticationResponse;
import com.warsen.artWeb.dto.UserDto;
import com.warsen.artWeb.model.entity.Role;
import com.warsen.artWeb.model.entity.User;
import com.warsen.artWeb.repository.RoleRepository;
import com.warsen.artWeb.repository.UserRepository;
import com.warsen.artWeb.security.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(UserDto request) {

        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName(UserRole.ROLE_USER.name()).orElseThrow();
        roles.add(role);

        User user = new User();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());
            user.setCreatedAt(new Date());
            user.setTotalPost(0L);
            user.setEnabled(true);
            user.setFollowerNumber(0L);
            user.setRoles(roles);
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse.Builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(UserDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse.Builder()
                .token(jwtToken)
                .build();
    }
}
