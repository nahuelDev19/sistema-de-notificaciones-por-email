package com.turnos.peluqueria.notificaciones.controller;

import com.turnos.peluqueria.notificaciones.entitys.Peluquero;
import com.turnos.peluqueria.notificaciones.repository.PeluqueroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peluqueros")
public class PeluqueroController {

    private final PeluqueroRepository peluqueroRepository;

    public PeluqueroController(PeluqueroRepository peluqueroRepository) {
        this.peluqueroRepository = peluqueroRepository;
    }

    @GetMapping
    public ResponseEntity<List<Peluquero>> obtenerTodos() {
        return ResponseEntity.ok(peluqueroRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Peluquero> crear(@RequestBody Peluquero peluquero) {
        return ResponseEntity.ok(peluqueroRepository.save(peluquero));
    }
}
