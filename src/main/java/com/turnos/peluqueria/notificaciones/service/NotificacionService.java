package com.turnos.peluqueria.notificaciones.service;

import com.turnos.peluqueria.notificaciones.dto.CreateEmail;
import com.turnos.peluqueria.notificaciones.dto.TurnoDTO;
import com.turnos.peluqueria.notificaciones.dto.TurnoRequest;
import com.turnos.peluqueria.notificaciones.entitys.Turno;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service @RequiredArgsConstructor
public class NotificacionService {

    private final RestTemplate restTemplate;

    // Por ahora loguea en consola
    // En el futuro acá se integraría WhatsApp, email, SMS, etc.
    /*
    public void enviarRecordatorio(TurnoDTO turno) {
        System.out.println("==============================");
        System.out.println("RECORDATORIO DE TURNO");
        System.out.println("Cliente : " + turno.getNombreCliente());
        System.out.println("Teléfono: " + turno.getTelefonoCliente());
        System.out.println("Peluquero: " + turno.getNombrePeluquero());
        System.out.println("Fecha/Hora: " + turno.getFechaHora());
        System.out.println("==============================");
    }
    */


    public void enviarRecordatorio(TurnoDTO turno) {
        CreateEmail params = CreateEmail.builder()
                .from("Acme <onboarding@resend.dev>")
                .to(turno.getEmailCliente())
                .subject("Recordatorio")
                .html("<p>Le recordamos que usted tiene un turno el dia: </p>"+turno.getFechaHora())
                .build();

        CreateEmailResponse data = resend.emails().send(params);
    }



}