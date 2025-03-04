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

    @Column(name = "codigo_aeropuerto", nullable = false, length = 10, unique = true)
    @JsonProperty("codigo_aeropuerto")
    private String codigo_aeropuerto;

    @Column(name = "nombre", nullable = false, length = 100)
    @JsonProperty("nombre")
    private String nombre;

    @Column(name = "ciudad", nullable = false, length = 100)
    @JsonProperty("ciudad")
    private String ciudad;

    @Column(name = "pais", nullable = false, length = 100)
    @JsonProperty("pais")
    private String pais;

    public Aeropuerto() {}

}
