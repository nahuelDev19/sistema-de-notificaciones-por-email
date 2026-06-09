package com.turnos.peluqueria.notificaciones.repository;

import com.turnos.peluqueria.notificaciones.entitys.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}