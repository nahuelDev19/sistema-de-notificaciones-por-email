package com.turnos.peluqueria.notificaciones.entitys;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;


@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHora;
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    //Lazy crea oop vacio para ocupar el lugar de la entidad relacionada
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "peluquero_id")
    private Peluquero peluquero;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public LocalDateTime getFechaHora() { return fechaHora; }

    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Peluquero getPeluquero() { return peluquero; }

    public void setPeluquero(Peluquero peluquero) { this.peluquero = peluquero; }
}