package com.example.travel_api.interfaces;

import com.example.travel_api.entity.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface aeropuertoRepository extends JpaRepository<Aeropuerto, Integer> {
}
