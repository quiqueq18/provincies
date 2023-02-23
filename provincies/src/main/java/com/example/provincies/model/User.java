package com.example.provincies.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    public String username;
    public String password;
    public boolean enabled;

    @OneToMany(mappedBy="username")
    public Set<Authority> authorities;

}

