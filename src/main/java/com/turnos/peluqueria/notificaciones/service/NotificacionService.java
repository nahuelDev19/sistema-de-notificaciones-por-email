package com.turnos.peluqueria.notificaciones.service;

import com.turnos.peluqueria.notificaciones.dto.CreateEmail;
import com.turnos.peluqueria.notificaciones.dto.CreateEmailResponse;
import com.turnos.peluqueria.notificaciones.dto.TurnoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service @RequiredArgsConstructor
public class NotificacionService {


    @Value("${API_RESEND_URL}")
    private String apiUrl;
    private final RestTemplate restTemplate;




    public CreateEmailResponse enviarRecordatorio(TurnoDTO turno) {


        CreateEmail params = CreateEmail.builder()
                .from("Acme <onboarding@resend.dev>")
                .to(List.of(turno.getEmailCliente()))
                .subject("Recordatorio")
                .html(formatoHtml(turno))
                .build();

        try {

        ResponseEntity<CreateEmailResponse> response =restTemplate
                .postForEntity( apiUrl,
                params,
                CreateEmailResponse.class);
        return response.getBody();


        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Error Resend [" + e.getStatusCode() + "]: " + e.getResponseBodyAsString());
        }
    }


   /* private String formatoHtml(TurnoDTO turnoDTO){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha = turnoDTO.getFechaHora().format(formatter);
        return  """
    <html>
        <body>
            <h2>Recordatorio de turno</h2>
            <p>Hola,</p>
            <p>Le recordamos que tiene un turno programado para:</p>
            <p><strong>%s</strong></p>
            <p>Por favor, asegúrese de asistir en el horario indicado.</p>
            <p>Saludos.</p>
        </body>
    </html>
    """.formatted(fecha);
    }*/

    private String formatoHtml(TurnoDTO turnoDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha = turnoDTO.getFechaHora().format(formatter);

        return """
        <html>
            <body>
                <h2>📅 Recordatorio de turno</h2>

                <p>Hola <strong>%s</strong>,</p>

                <p>Le recordamos que tiene un turno programado con los siguientes datos:</p>

                <table border="1">
                    <tr>
                        <td><strong>Cliente</strong></td>
                        <td>%s</td>
                    </tr>
                    <tr>
                        <td><strong>Teléfono</strong></td>
                        <td>%s</td>
                    </tr>
                    <tr>
                        <td><strong>Peluquero</strong></td>
                        <td>%s</td>
                    </tr>
                    <tr>
                        <td><strong>Fecha y hora</strong></td>
                        <td>%s</td>
                    </tr>
                </table>

                <p>Por favor, asegúrese de asistir en el horario indicado.</p>

                <p><strong>¡Gracias por confiar en nosotros!</strong></p>

                <hr>

                <p>Este es un mensaje automático, por favor no responda a este correo.</p>
            </body>
        </html>
        """
                .formatted(
                        turnoDTO.getNombreCliente(),
                        turnoDTO.getNombreCliente(),
                        turnoDTO.getTelefonoCliente(),
                        turnoDTO.getNombrePeluquero(),
                        fecha
                );
    }

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


}