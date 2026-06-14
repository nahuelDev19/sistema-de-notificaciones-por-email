package com.turnos.peluqueria.notificaciones.cron;

import com.turnos.peluqueria.notificaciones.dto.TurnoDTO;
import com.turnos.peluqueria.notificaciones.entitys.Turno;
import com.turnos.peluqueria.notificaciones.repository.TurnoRepository;
import com.turnos.peluqueria.notificaciones.service.NotificacionService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TurnoNotificacionScheduler {

    private final TurnoRepository turnoRepository;
    private final NotificacionService notificacionService;

    public TurnoNotificacionScheduler(TurnoRepository turnoRepository,
                                      NotificacionService notificacionService) {
        this.turnoRepository = turnoRepository;
        this.notificacionService = notificacionService;
    }

    // Se ejecuta cada 60 segundos
    // Busca turnos confirmados que estén entre 1h y 2h desde ahora
    @Scheduled(fixedRate = 60000)
    public void notificarTurnosProximos() {
        LocalDateTime desde = LocalDateTime.now().plusHours(1);
        LocalDateTime hasta = LocalDateTime.now().plusHours(2);

        List<Turno> turnos = turnoRepository.findTurnosProximos(desde, hasta);
        /*
        turnos.stream()
                .map(TurnoDTO::new)
                .forEach(notificacionService::enviarRecordatorio);
        */
        turnos.forEach(turno -> {
            notificacionService.enviarRecordatorio(new TurnoDTO(turno));
            turno.setRecordatorioEnviado(true);
            turnoRepository.save(turno);
        });


    }
}
