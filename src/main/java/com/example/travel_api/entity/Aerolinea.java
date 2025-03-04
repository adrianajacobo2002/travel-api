package com.example.travel_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "aerolineas")
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_aerolinea")
    private int id_aerolinea;

    @Column(name = "nombre", nullable = false, length = 100)
    @JsonProperty("nombre")
    private String nombre;

    @Column(name = "codigo_aerolinea", nullable = false, length = 10, unique = true)
    @JsonProperty("codigo_aerolinea")
    private String codigo_aerolinea;

    public Aerolinea() {}
}
