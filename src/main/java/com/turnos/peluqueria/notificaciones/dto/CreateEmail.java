package com.turnos.peluqueria.notificaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class CreateEmail {



    private String from;
    private String to;
    private String subject;
    private String html;

}
