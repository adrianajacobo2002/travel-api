package com.example.travel_api.controller;

import com.example.travel_api.Service.PasajeroService;
import com.example.travel_api.entity.Pasajero;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroController {
    private PasajeroService pasajeroService;

    @GetMapping("/reserva/{idReserva}")
    public ResponseEntity<List<Pasajero>> obtenerPasajeros(@PathVariable int idReserva) {
        return ResponseEntity.ok(pasajeroService.getPasajerosPorReserva(idReserva));
    }

    @PostMapping
    public ResponseEntity<Pasajero> crearPasajero(@RequestBody Pasajero pasajero) {
        return ResponseEntity.ok(pasajeroService.agregarPasajero(pasajero));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPasajero(@PathVariable int id) {
        pasajeroService.eliminarPasajero(id);
        return ResponseEntity.noContent().build();
    }
}
