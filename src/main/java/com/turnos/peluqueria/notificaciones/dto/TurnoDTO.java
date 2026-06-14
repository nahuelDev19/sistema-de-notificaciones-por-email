package com.turnos.peluqueria.notificaciones.dto;

import com.turnos.peluqueria.notificaciones.entitys.Turno;

import java.time.LocalDateTime;

public class TurnoDTO {

    private Long id;
    private LocalDateTime fechaHora;
    private String estado;
    private String nombreCliente;
    private String telefonoCliente;
    private String nombrePeluquero;
    private String emailCliente;


    public TurnoDTO(Turno turno) {
        this.id = turno.getId();
        this.fechaHora = turno.getFechaHora();
        this.estado = turno.getEstado();
        this.nombreCliente = turno.getCliente().getNombre();
        this.telefonoCliente = turno.getCliente().getTelefono();
        this.nombrePeluquero = turno.getPeluquero().getNombre();
        this.emailCliente= turno.getCliente().getEmail();
    }

    public Long getId() { return id; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getEstado() { return estado; }
    public String getNombreCliente() { return nombreCliente; }
    public String getTelefonoCliente() { return telefonoCliente; }
    public String getNombrePeluquero() { return nombrePeluquero; }




    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }


}