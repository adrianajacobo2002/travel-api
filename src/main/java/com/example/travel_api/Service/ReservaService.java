package com.example.travel_api.Service;

import com.example.travel_api.entity.Reserva;
import com.example.travel_api.interfaces.reservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private reservaRepository repository;

    public Optional<Reserva> getReservaById(int id) {
        return repository.findById(id);
    }

    public Reserva addReserva(Reserva reserva) {
        return repository.save(reserva);
    }

    public void deleteReserva(int id) {
        repository.deleteById(id);
    }

}
