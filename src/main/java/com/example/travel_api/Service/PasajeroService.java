package com.example.travel_api.Service;

import com.example.travel_api.entity.Pasajero;
import com.example.travel_api.interfaces.pasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajeroService {

    @Autowired
    private pasajeroRepository repository;

    public List<Pasajero> getPasajerosPorReserva(int id_reserva) {
        return repository.findByReserva(id_reserva);

    }

    public Optional<Pasajero> getPasajeroPorId(int id) {
        return repository.findById(id);
    }

    public Pasajero agregarPasajero(Pasajero pasajero) {
        return repository.save(pasajero);
    }

    public void eliminarPasajero(int id) {
        repository.deleteById(id);
    }
}

