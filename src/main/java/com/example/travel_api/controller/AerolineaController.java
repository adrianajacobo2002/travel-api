package com.example.travel_api.controller;

import com.example.travel_api.Service.AerolineaService;
import com.example.travel_api.entity.Aerolinea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aerolinea")
public class AerolineaController {
    @Autowired
    private AerolineaService aerolineaService;

    @GetMapping
    public List<Aerolinea> getAerolineas(){
        return aerolineaService.getAllAerolinea();
    }

    @GetMapping("/{id}")
    public Optional<Aerolinea> getAerolineaById(@PathVariable int id){
        return aerolineaService.getAerolineaById(id);
    }

    @PostMapping
    public Aerolinea createAerolinea(@RequestBody Aerolinea aerolinea){
        return aerolineaService.crearAerolinea(aerolinea);
    }

    @PutMapping("/{id}")
    public Aerolinea updateAerolinea(@PathVariable int id, @RequestBody Aerolinea aerolinea){
        return aerolineaService.actualizarAerolinea(id, aerolinea);

    }

    @DeleteMapping("/{id}")
    public void deleteAerolinea(@PathVariable int id){
        aerolineaService.eliminarAerolinea(id);
    }

}
