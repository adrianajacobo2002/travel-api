package com.example.travel_api.controller;

import com.example.travel_api.Service.ReservaService;
import com.example.travel_api.entity.Reserva;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private ReservaService reservaService;

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReserva(@PathVariable int id) {
        Optional<Reserva> reserva = reservaService.getReservaById(id);
        return reserva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.addReserva(reserva));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reserva> deleteReserva(@PathVariable int id) {
        reservaService.deleteReserva(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/confirmar")
    public ResponseEntity<Reserva> confirmReserva(@PathVariable int id) {
        Optional<Reserva> reserva = reservaService.getReservaById(id);
        if (reserva.isPresent()) {
            Reserva re = reserva.get();
            re.setEstado(Reserva.Estado.completado);
            return ResponseEntity.ok(reservaService.addReserva(re));
        }
        return ResponseEntity.notFound().build();
    }
}
