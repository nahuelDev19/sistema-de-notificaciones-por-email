package com.turnos.peluqueria.notificaciones.service;

import com.turnos.peluqueria.notificaciones.entitys.Cliente;
import com.turnos.peluqueria.notificaciones.entitys.Peluquero;
import com.turnos.peluqueria.notificaciones.repository.ClienteRepository;
import com.turnos.peluqueria.notificaciones.repository.PeluqueroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }


    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }



}
