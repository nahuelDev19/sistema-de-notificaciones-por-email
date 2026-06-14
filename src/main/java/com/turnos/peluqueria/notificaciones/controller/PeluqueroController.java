package com.turnos.peluqueria.notificaciones.controller;

import com.turnos.peluqueria.notificaciones.entitys.Peluquero;
import com.turnos.peluqueria.notificaciones.repository.PeluqueroRepository;
import com.turnos.peluqueria.notificaciones.service.PeluqueroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peluqueros")
public class PeluqueroController {

    private final PeluqueroService peluqueroService;

    public PeluqueroController(PeluqueroService peluqueroService) {
        this.peluqueroService = peluqueroService;
    }

    @GetMapping
    public ResponseEntity<List<Peluquero>> obtenerTodos() {
        return ResponseEntity.ok(peluqueroService.findAll());
    }

    @PostMapping
    public ResponseEntity<Peluquero> crear(@RequestBody Peluquero peluquero) {
        return ResponseEntity.ok(peluqueroService.save(peluquero));
    }
}
