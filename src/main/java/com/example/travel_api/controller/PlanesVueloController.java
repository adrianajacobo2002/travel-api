package com.example.travel_api.controller;

import com.example.travel_api.Service.PlanesVueloService;
import com.example.travel_api.entity.Aerolinea;
import com.example.travel_api.entity.Aeropuerto;
import com.example.travel_api.entity.PlanesVuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planes-vuelo")
public class PlanesVueloController {
    @Autowired
    PlanesVueloService planesVueloService;

    @GetMapping
    public List<PlanesVuelo> GetPlanesVuelo() {
        return planesVueloService.getAllPlanesVuelo();
    }

    @GetMapping("/{id}")
    public Optional<PlanesVuelo> getPlanVuelo(@PathVariable int id){
        return planesVueloService.getPlanesVueloById(id);
    }
}
