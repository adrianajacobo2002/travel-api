package com.example.travel_api.interfaces;

import com.example.travel_api.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reservaRepository extends JpaRepository<Reserva, Integer> {

}
