package com.turnos.peluqueria.notificaciones.repository;

import com.turnos.peluqueria.notificaciones.entitys.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {

    @Query("SELECT t FROM Turno t WHERE t.peluquero.id = :peluqueroId")
    List<Turno> findByPeluqueroId(@Param("peluqueroId") Long peluqueroId);

    @Query("SELECT t FROM Turno t WHERE t.estado = :estado")
    List<Turno> findByEstado(@Param("estado") String estado);

    @Query("SELECT t FROM Turno t JOIN FETCH t.cliente JOIN FETCH t.peluquero")
    List<Turno> findAllOptimizado();

    // Para el cron — trae turnos CONFIRMADOS en el rango de tiempo indicado
    @Query("SELECT t FROM Turno t JOIN FETCH t.cliente JOIN FETCH t.peluquero " +
            "WHERE t.estado = 'CONFIRMADO' " +
            "AND t.fechaHora BETWEEN :desde AND :hasta")
    List<Turno> findTurnosProximos(
            @Param("desde") LocalDateTime desde,
            @Param("hasta") LocalDateTime hasta
    );
}