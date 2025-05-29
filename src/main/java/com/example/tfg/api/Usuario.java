package com.example.tfg.api;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class Usuario {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // Usamos AUTO para UUID
    public UUID id;
    public String username;
    public String password;
    public boolean enabled;

    @OneToMany(mappedBy = "username")
    public Set<Authority> authorities;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
