package com.turnos.peluqueria.notificaciones.service;

import com.turnos.peluqueria.notificaciones.entitys.Peluquero;
import com.turnos.peluqueria.notificaciones.repository.PeluqueroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PeluqueroService {

    private PeluqueroRepository peluqueroRepository;

    public List<Peluquero> findAll(){
        return peluqueroRepository.findAll();
    }


    public Peluquero save(Peluquero peluquero){
        return peluqueroRepository.save(peluquero);
    }


}
