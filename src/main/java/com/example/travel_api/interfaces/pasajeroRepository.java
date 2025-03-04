package com.example.travel_api.interfaces;

import com.example.travel_api.entity.Pasajero;
import com.example.travel_api.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpAnd;

import java.util.List;
import java.util.Optional;

public interface pasajeroRepository extends JpaRepository<Pasajero, Integer> {
    List<Pasajero> findByReserva(int id_reserva);
}
