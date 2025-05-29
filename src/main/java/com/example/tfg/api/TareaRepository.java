package com.example.tfg.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TareaRepository extends JpaRepository<Tarea, UUID> {
   @Query("SELECT t FROM Tarea t WHERE t.usuario.id = :usuarioId AND t.completada = false")
    List<Tarea> findTareasPendientesByUsuarioId(@Param("usuarioId") UUID usuarioId);
}

