package com.example.travel_api.interfaces;

import com.example.travel_api.entity.Escala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface escalaRepository extends JpaRepository<Escala, Integer> {
    @Query("SELECT e FROM Escala e WHERE e.vuelo_principal.id_vuelo = :id_vuelo ORDER BY e.orden_escala ASC")
    List<Escala> findEscalasByVuelo(@Param("id_vuelo") int id_vuelo);
}
