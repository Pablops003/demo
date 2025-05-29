package com.example.tfg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        tarea.usuario = usuario;
        return tareaRepo.save(tarea);
    }

    @GetMapping("/usuario/{id}")
    public List<Tarea> getTareasDeUsuario(@PathVariable UUID id) {
        return tareaRepo.findAll().stream()
                .filter(t -> t.usuario.id.equals(id))
                .collect(Collectors.toList());
    }

    @PutMapping("/usuario/{id}/tarea/{tareaId}")
    public ResponseEntity<Tarea> actualizarTarea(
            @PathVariable UUID id,
            @PathVariable UUID tareaId,
            @RequestBody Tarea tareaActualizada) {

        Optional<Tarea> tareaOpt = tareaRepo.findById(tareaId);
        if (tareaOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Tarea tarea = tareaOpt.get();

        //  pertenece al usuario
        if (!tarea.getUsuario().getId().equals(id)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        tarea.setTitulo(tareaActualizada.getTitulo());
        tarea.setDescripcion(tareaActualizada.getDescripcion());
        tarea.setPrioridad(tareaActualizada.getPrioridad());
        tarea.setFecha(tareaActualizada.getFecha());
        tarea.setCompletada(tareaActualizada.isCompletada());

        Tarea tareaGuardada = tareaRepo.save(tarea);
        return ResponseEntity.ok(tareaGuardada);
    }

    @DeleteMapping("/usuario/{id}/tarea/{tareaId}")
    public ResponseEntity<Void> borrarTarea(
            @PathVariable UUID id,
            @PathVariable UUID tareaId) {

        Optional<Tarea> tareaOpt = tareaRepo.findById(tareaId);
        if (tareaOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Tarea tarea = tareaOpt.get();
        if (!tarea.getUsuario().getId().equals(id)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        tareaRepo.delete(tarea);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{id}/completadas")
    public List<Tarea> getTareasCompletadas(@PathVariable UUID id) {
        return tareaRepo.findAll().stream()
                .filter(t -> t.getUsuario().getId().equals(id) && t.isCompletada())
                .collect(Collectors.toList());
    }
    @GetMapping("/usuario/{id}/pendientes")
    public List<Tarea> getTareasPendientes(@PathVariable UUID id) {
        return tareaRepo.findTareasPendientesByUsuarioId(id);
//        return tareaRepo.findAll().stream()
//                .filter(t -> t.getUsuario().getId().equals(usuarioId) && !t.isCompletada())
//                .collect(Collectors.toList());
    }

    //Probar a ver si funciona

    @GetMapping("/usuario/{id}/tarea/{tareaId}")
    public ResponseEntity<Tarea> getTareaPorId(
            @PathVariable UUID id,
            @PathVariable UUID tareaId) {

        Optional<Tarea> tareaOpt = tareaRepo.findById(tareaId);
        if (tareaOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Tarea tarea = tareaOpt.get();

        if (!tarea.getUsuario().getId().equals(id)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        return ResponseEntity.ok(tarea);
    }

}

