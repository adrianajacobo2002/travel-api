package com.example.travel_api.Service;

import com.example.travel_api.entity.Escala;
import com.example.travel_api.interfaces.escalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscalaService {

    @Autowired
    private escalaRepository repo;

    public List<Escala> obtenerEscalasDeVuelo(int id_vuelo) {
        return repo.findEscalasByVuelo(id_vuelo);
    }
}
