package com.turnos.peluqueria.notificaciones.repository;

import com.turnos.peluqueria.notificaciones.entitys.Peluquero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeluqueroRepository extends JpaRepository<Peluquero, Long> {
}