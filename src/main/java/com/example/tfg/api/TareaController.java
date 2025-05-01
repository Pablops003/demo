package com.example.tfg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping("/")
    public List<Tarea> findAll(){
        return tareaRepository.findAll();
    }
    }
