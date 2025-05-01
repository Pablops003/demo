package com.example.tfg.api;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String titulo;



}
