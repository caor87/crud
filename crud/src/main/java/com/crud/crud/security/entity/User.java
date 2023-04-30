package com.crud.crud.security.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    @Column(unique = true)
    private String userName;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String name, @NonNull String nameUser, @NonNull String email, @NonNull String password) {
        this.name = name;
        this.userName = nameUser;
        this.email = email;
        this.password = password;
    }
}
