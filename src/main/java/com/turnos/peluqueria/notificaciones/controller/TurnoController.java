package com.turnos.peluqueria.notificaciones.controller;

import com.turnos.peluqueria.notificaciones.dto.TurnoDTO;
import com.turnos.peluqueria.notificaciones.dto.TurnoRequest;
import com.turnos.peluqueria.notificaciones.service.TurnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping
    public ResponseEntity<List<TurnoDTO>> obtenerTodos() {
        return ResponseEntity.ok(turnoService.obtenerTodos());
    }

    @GetMapping("/optimizado")
    public ResponseEntity<List<TurnoDTO>> obtenerTodosOptimizado() {
        return ResponseEntity.ok(turnoService.obtenerTodosOptimizado());
    }

    @GetMapping("/peluquero/{id}")
    public ResponseEntity<List<TurnoDTO>> obtenerPorPeluquero(@PathVariable Long id) {
        return ResponseEntity.ok(turnoService.obtenerPorPeluquero(id));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<TurnoDTO>> obtenerPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(turnoService.obtenerPorEstado(estado));
    }

    @PostMapping
    public ResponseEntity<TurnoDTO> crear(@RequestBody TurnoRequest request) {
        return ResponseEntity.ok(turnoService.crear(
                request.getClienteId(),
                request.getPeluqueroId(),
                request.getFechaHora(),
                request.getEstado()
        ));
    }
}