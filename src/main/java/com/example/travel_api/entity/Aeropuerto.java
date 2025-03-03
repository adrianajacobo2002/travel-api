package com.example.travel_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "aeropuertos")
public class Aeropuerto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_aeropuerto")
    private int id_aeropuerto;

    @JsonProperty("codigo_aeropuerto")
    private String codigo_aeropuerto;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("ciudad")
    private String ciudad;

    @JsonProperty("pais")
    private String pais;

    public Aeropuerto() {}

}
