package com.example.travel_api.Service;

import com.example.travel_api.entity.Aeropuerto;
import com.example.travel_api.interfaces.aeropuertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeropuertoService {
    @Autowired
    private aeropuertoRepository repo;

    public List<Aeropuerto> listarAeropuertos() {
        return repo.findAll();
    }


}
