package com.example.travel_api.interfaces;

import com.example.travel_api.entity.PlanesVuelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface planesvueloRepository extends JpaRepository<PlanesVuelo, Integer> {
    Optional<PlanesVuelo> findPlanesVueloById(int id);
}
