package com.example.tfg.api;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TareaRepository extends JpaRepository<Tarea, UUID> {
}

