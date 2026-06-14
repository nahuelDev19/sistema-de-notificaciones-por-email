package com.turnos.peluqueria.notificaciones.controller;

import com.turnos.peluqueria.notificaciones.entitys.Cliente;
import com.turnos.peluqueria.notificaciones.repository.ClienteRepository;
import com.turnos.peluqueria.notificaciones.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerTodos() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.save(cliente));
    }
}