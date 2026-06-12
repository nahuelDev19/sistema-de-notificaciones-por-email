package com.turnos.peluqueria.notificaciones.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {


    @Value("${RESEND_API_KEY}")
    private String apiKey;


    @Value("${API_RESEND_URL}")
    private String apiUrl;

    @Bean
    public RestTemplate restTemplate(){
    System.out.println(">>> API KEY cargada: " + apiKey); // ⚠️ solo para debug, sacalo después
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().set("Authorization", "Bearer " + apiKey);
            request.getHeaders().set("Content-Type", "application/json");
            return execution.execute(request, body);
        });

        return restTemplate;
    }





}
