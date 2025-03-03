package com.example.travel_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "planes_vuelo")
public class PlanesVuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_plan")
    private int id_plan;

    @JsonProperty("nombre_plan")
    private String nombre_plan;

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("precio_extra")
    private double precio_extra;

    @JsonProperty("equipaje_mano")
    private boolean equipaje_mano;

    @JsonProperty("equipaje_bodega")
    private boolean equipaje_bodega;

    @JsonProperty("comida_abordo")
    private boolean comida_abordo;

    @JsonProperty("reembolso")
    private boolean reembolso;

    public PlanesVuelo() {}

}
