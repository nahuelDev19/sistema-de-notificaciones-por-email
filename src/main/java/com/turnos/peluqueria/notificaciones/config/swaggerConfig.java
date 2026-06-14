package com.turnos.peluqueria.notificaciones.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class swaggerConfig {


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Envío de Notificaciones")
                        .version("1.0")
                        .description("""
                            API desarrollada para automatizar el envío de recordatorios por correo electrónico a clientes con turnos programados.

                            El sistema utiliza tareas programadas (Cron Jobs) que se ejecutan cada 60 segundos para identificar turnos próximos y enviar notificaciones de manera automática.

                            Características principales:
                            - Consulta automática de turnos próximos.
                            - Envío de recordatorios por email.
                            - Ejecución periódica mediante Cron.
                            - Gestión de clientes y turnos.
                            - Entorno de pruebas local.
                            """)
                        .contact(new Contact()
                                .name("Nahuel Perea")
                                .email("nahuel.perea@gmail.com")));
    }



}
