package com.warsen.artWeb.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.LazyCollection;


import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true, name = "username")
    private String username;

    @NotBlank
    @Column(nullable = false, name = "password")
    private String password;

    @NotBlank
    @Column(nullable = false, unique = true, name = "email")
    private String email;

    @Column(name = "follower_number")
    private String followerNumber;

    @Column(nullable = false, name = "created_at")
    private Date createdAt;

    @Column(nullable = false, name = "last_login")
    private Date lasLogin;

    @Column(nullable = false, name = "total_post")
    private Long totalPost;

    @Column(nullable = false, name = "enabled")
    private boolean enabled;


    @ManyToMany
    @Column(name = "roles")
    private Set<Role> roles;

    public User(Long id, String username, String password,
                String email, String followerNumber, Date createdAt,
                Date lasLogin, Long totalPost, boolean enabled,
                Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.followerNumber = followerNumber;
        this.createdAt = createdAt;
        this.lasLogin = lasLogin;
        this.totalPost = totalPost;
        this.enabled = enabled;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFollowerNumber() {
        return followerNumber;
    }

    public void setFollowerNumber(String followerNumber) {
        this.followerNumber = followerNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLasLogin() {
        return lasLogin;
    }

    public void setLasLogin(Date lasLogin) {
        this.lasLogin = lasLogin;
    }

    public Long getTotalPost() {
        return totalPost;
    }

    public void setTotalPost(Long totalPost) {
        this.totalPost = totalPost;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
