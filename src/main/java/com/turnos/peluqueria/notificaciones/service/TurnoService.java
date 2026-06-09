package com.turnos.peluqueria.notificaciones.service;

import com.turnos.peluqueria.notificaciones.dto.TurnoDTO;
import com.turnos.peluqueria.notificaciones.entitys.Cliente;
import com.turnos.peluqueria.notificaciones.entitys.Peluquero;
import com.turnos.peluqueria.notificaciones.entitys.Turno;
import com.turnos.peluqueria.notificaciones.repository.ClienteRepository;
import com.turnos.peluqueria.notificaciones.repository.PeluqueroRepository;
import com.turnos.peluqueria.notificaciones.repository.TurnoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TurnoService {

    private final TurnoRepository turnoRepository;
    private final ClienteRepository clienteRepository;
    private final PeluqueroRepository peluqueroRepository;

    public TurnoService(TurnoRepository turnoRepository,
                        ClienteRepository clienteRepository,
                        PeluqueroRepository peluqueroRepository) {
        this.turnoRepository = turnoRepository;
        this.clienteRepository = clienteRepository;
        this.peluqueroRepository = peluqueroRepository;
    }

    public List<TurnoDTO> obtenerTodos() {
        return turnoRepository.findAll()
                .stream()
                .map(TurnoDTO::new)
                .toList();
    }

    public List<TurnoDTO> obtenerTodosOptimizado() {
        return turnoRepository.findAllOptimizado()
                .stream()
                .map(TurnoDTO::new)
                .toList();
    }

    public List<TurnoDTO> obtenerPorPeluquero(Long peluqueroId) {
        return turnoRepository.findByPeluqueroId(peluqueroId)
                .stream()
                .map(TurnoDTO::new)
                .toList();
    }

    public List<TurnoDTO> obtenerPorEstado(String estado) {
        return turnoRepository.findByEstado(estado)
                .stream()
                .map(TurnoDTO::new)
                .toList();
    }

    public TurnoDTO crear(Long clienteId, Long peluqueroId,
                          LocalDateTime fechaHora, String estado) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Peluquero peluquero = peluqueroRepository.findById(peluqueroId)
                .orElseThrow(() -> new RuntimeException("Peluquero no encontrado"));

        Turno turno = new Turno();
        turno.setCliente(cliente);
        turno.setPeluquero(peluquero);
        turno.setFechaHora(fechaHora);
        turno.setEstado(estado);

        return new TurnoDTO(turnoRepository.save(turno));
    }
}