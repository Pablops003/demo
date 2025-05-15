package com.example.tfg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repo;

    @GetMapping("/all")
    List<Usuario> getAll() {
        return repo.findAll();
    }

    @PostMapping("/registro")
    public Usuario registrar(@RequestBody Usuario u) {
        return repo.save(u);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> datos) {
        String correo = datos.get("correo");
        String contrasena = datos.get("contrasena");

        Optional<Usuario> u = repo.findByCorreo(correo);
        if (u.isPresent() && u.get().getContrasena().equals(contrasena)) {
            return ResponseEntity.ok(u.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No es valido");
        }
    }
}

