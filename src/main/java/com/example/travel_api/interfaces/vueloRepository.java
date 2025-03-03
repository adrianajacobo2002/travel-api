package com.example.travel_api.interfaces;

import com.example.travel_api.entity.Vuelo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface vueloRepository extends JpaRepository<Vuelo, Integer> {

    @Query("SELECT v FROM Vuelo v WHERE v.origen.id_aeropuerto = :origen " +
            "AND v.destino.id_aeropuerto = :destino " +
            "AND v.fecha_salida >= :fecha_salida " +
            "ORDER BY v.fecha_salida ASC")

    List<Vuelo> buscarVuelos(
            @Param("origen") int origen,
            @Param("destino") int destino,
            @Param("fecha_salida") LocalDateTime fecha_salida
    );
}
