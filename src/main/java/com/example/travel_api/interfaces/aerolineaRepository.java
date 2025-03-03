package com.example.travel_api.interfaces;

import com.example.travel_api.entity.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface aerolineaRepository extends JpaRepository<Aerolinea, Integer> {
    Optional<Aerolinea> findByNombre(String nombre);
}
