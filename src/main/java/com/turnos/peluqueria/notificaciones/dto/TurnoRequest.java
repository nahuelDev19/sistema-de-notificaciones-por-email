package com.turnos.peluqueria.notificaciones.dto;

import java.time.LocalDateTime;

public class TurnoRequest {
    private Long clienteId;
    private Long peluqueroId;
    private LocalDateTime fechaHora;
    private String estado;

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public Long getPeluqueroId() { return peluqueroId; }
    public void setPeluqueroId(Long peluqueroId) { this.peluqueroId = peluqueroId; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}