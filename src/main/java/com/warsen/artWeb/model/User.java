package com.warsen.artWeb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@Table(name = "USER")
public class User {

    /*
    Table user {
  id long [primary key, ref: < posts.user_id]
  username varchar
  password varchar
  email varchar
  follower_number long
  role varchar
  created_at datetime
  last_login datetime
  total_posts long
}
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "username")
    private String username;

    @NotBlank
    @Column(name = "password")
    private String password;

    @NotBlank
    @Column(name = "email")
    private String email;

    @Column(name = "follower_number")
    private String followerNumber;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "token_expired")
    private boolean tokenExpired;

    @Column(name = "roles")
    private Set<Role> roles;
}
