package com.example.tfg.api;

import java.util.UUID;

public class UsuarioDTO {
    private UUID id;
    private String username;

//    public UsuarioDTO(UUID id, String username) {
//    }

    public UsuarioDTO(UUID id, String username) {
        this.id = id;
        this.username = username;
    }
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
}
