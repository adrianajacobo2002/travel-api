package com.example.travel_api.controller;

import com.example.travel_api.Service.AeropuertoService;
import com.example.travel_api.entity.Aeropuerto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aeropuerto")
public class AeropuertoController {

    @Autowired
    private AeropuertoService aeropuertoService;

    @GetMapping
    public List<Aeropuerto> obtenerAeropuertos() {
        return aeropuertoService.listarAeropuertos();
    }

    @PostMapping
    public Aeropuerto createAeropuerto(@RequestBody Aeropuerto aeropuerto) {
        return aeropuertoService.crearAeropuerto(aeropuerto);
    }
}
