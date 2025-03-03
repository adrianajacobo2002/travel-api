package com.example.travel_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vuelos_clases")
public class VueloClase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_vuelo_clase")
    private int id_vuelo_clase;

    @JsonProperty("id_vuelo")
    private int id_vuelo;

    @JsonProperty("nombre_clase")
    private String nombre_clase;

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("precio_extra")
    private double precio_extra;

    @JsonProperty("asientos_disponibles")
    private int asientos_disponibles;

    @JsonProperty("asientos_totales")
    private int asientos_totales;

    public VueloClase() {}
}
