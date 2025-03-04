package com.example.travel_api.interfaces;

import com.example.travel_api.entity.Vuelo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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


    @Query("SELECT v FROM Vuelo v WHERE v.origen.id_aeropuerto = :origen " +
            "AND v.destino.id_aeropuerto = :destino " +
            "AND v.fecha_salida >= :fecha_salida " +
            "AND (:fecha_regreso IS NULL OR v.fecha_regreso = :fecha_regreso) " +
            "AND (:tipo_vuelo IS NULL OR v.tipo_vuelo =:tipoVuelo ) " +
            "AND (:aerolinea IS NULL OR v.aerolinea.id_aerolinea = :aerolinea) " +
            "ORDER BY v.fecha_salida ASC")

    List<Vuelo> buscarVuelosDirectos(@Param("origen") int origen,
                                     @Param("destino") int destino,
                                     @Param("fecha_salida") LocalDateTime fecha_salida,
                                     @Param("fecha_regreso") LocalDateTime fecha_regreso,
                                     @Param("tipo_vuelo") Vuelo.TipoVuelo tipoVuelo,
                                     @Param("aerolinea") Integer aerolinea);

    @Query("SELECT v1, v2 FROM Vuelo v1 " +
            "JOIN Escala e ON v1.id_vuelo = e.vuelo_principal.id_vuelo " +
            "JOIN Vuelo v2 ON e.vuelo_escala.id_vuelo = v2.id_vuelo " +
            "WHERE v1.origen.id_aeropuerto = :origen " +
            "AND v2.destino.id_aeropuerto = :destino " +
            "AND v1.fecha_salida >= :fecha_salida " +
            "AND (:fecha_regreso IS NULL OR v2.fecha_regreso = :fecha_regreso) " +
            "AND (:tipo_vuelo IS NULL OR v1.tipo_vuelo = :tipo_vuelo) " +
            "AND (:aerolinea IS NULL OR v1.aerolinea.id_aerolinea = :aerolinea) " +
            "ORDER BY v1.fecha_salida ASC")
    List<Object[]> buscarVuelosEscalas(@Param("origen") int origen,
                                    @Param("destino") int destino,
                                    @Param("fecha_salida") LocalDateTime fecha_salida,
                                    @Param("fecha_regreso") LocalDateTime fecha_regreso,
                                    @Param("tipo_vuelo") Vuelo.TipoVuelo tipoVuelo,
                                    @Param("aerolinea") Integer aerolinea);


    @Query("SELECT v FROM Vuelo v WHERE v.origen.id_aeropuerto = :origen " +
            "AND v.destino.id_aeropuerto = :destino " +
            "AND v.fecha_salida >= :fecha_salida " +
            "AND (:fecha_regreso IS NULL OR v.fecha_regreso = :fecha_regreso) " +
            "AND (:tipo_vuelo IS NULL OR v.tipo_vuelo = :tipo_vuelo) " +
            "AND (:aerolinea IS NULL OR v.aerolinea.id_aerolinea = :aerolinea) " +
            "ORDER BY v.fecha_salida ASC")

    List<Vuelo> buscarVuelosDirectosoEscalas(@Param("origen") int origen,
                                             @Param("destino") int destino,
                                             @Param("fecha_salida") LocalDateTime fecha_salida,
                                             @Param("fecha_regreso") LocalDateTime fecha_regreso,
                                             @Param("tipo_vuelo") Vuelo.TipoVuelo tipo_vuelo,
                                             @Param("aerolinea") Integer aerolinea);

}
