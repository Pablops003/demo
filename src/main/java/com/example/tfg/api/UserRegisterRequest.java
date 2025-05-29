package com.example.tfg.api;



import jakarta.validation.constraints.NotBlank;

public class UserRegisterRequest {

    @NotBlank(message = "El nom d'usuari és obligatori")
    private String username;

    @NotBlank(message = "La contrasenya és obligatòria")
    private String password;

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

    @Override
    public String toString() {
        return "UserRegisterRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
