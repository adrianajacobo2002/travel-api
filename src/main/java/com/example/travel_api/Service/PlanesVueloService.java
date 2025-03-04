package com.example.travel_api.Service;

import com.example.travel_api.entity.Aerolinea;
import com.example.travel_api.entity.PlanesVuelo;
import com.example.travel_api.interfaces.planesvueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanesVueloService {
    @Autowired
    private planesvueloRepository repo;

    public List<PlanesVuelo> getAllPlanesVuelo() {
        return repo.findAll();
    }

    public Optional<PlanesVuelo> getPlanesVueloById(int id) {
        return repo.findById(id);
    }

}
