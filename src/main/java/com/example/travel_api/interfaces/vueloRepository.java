package com.example.travel_api.interfaces;

import com.example.travel_api.entity.Vuelo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface vueloRepository extends JpaRepository<Vuelo, Integer> {

    @Query("SELECT v FROM Vuelo v " +
            "WHERE v.origen.id_aeropuerto = :origen " +
            "AND v.destino.id_aeropuerto = :destino " +
            "AND v.fecha_salida >= :fecha_salida " +
            "AND (:fecha_regreso IS NULL OR v.fecha_regreso = :fecha_regreso) " +
            "AND (:tipoVuelo IS NULL OR v.tipo_vuelo = :tipoVuelo) " +
            "AND (:aerolinea IS NULL OR v.aerolinea.id_aerolinea = :aerolinea) " +
            "ORDER BY v.fecha_salida ASC")

    List<Vuelo> buscarVuelos(
            @Param("origen") int origen,
            @Param("destino") int destino,
            @Param("fecha_salida") LocalDateTime fecha_salida,
            @Param("fecha_regreso")LocalDateTime fecha_regreso,
            @Param("tipoVuelo") Vuelo.TipoVuelo tipoVuelo,
            @Param("aerolinea") Integer aerolinea
            );
}
