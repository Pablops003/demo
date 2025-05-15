package com.example.tfg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @GetMapping("/")
    public List<Tarea> getAll(){
        return tareaRepo.findAll();
    }

    @PostMapping("/usuario/{id}")
    public Tarea crearParaUsuario(@PathVariable UUID id, @RequestBody Tarea tarea) {
        Usuario usuario = usuarioRepo.findById(id).orElseThrow();
        tarea.setUsuario(usuario);
        return tareaRepo.save(tarea);
    }

    @GetMapping("/usuario/{id}")
    public List<Tarea> getTareasDeUsuario(@PathVariable UUID id) {
        return tareaRepo.findAll().stream()
                .filter(t -> t.getUsuario().getId().equals(id))
                .collect(Collectors.toList());
    }
}

