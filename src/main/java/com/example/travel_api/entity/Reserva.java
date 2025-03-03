package com.example.travel_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_reserva")
    private int id_reserva;

    @JsonProperty("id_usuario")
    private int id_usuario;

    @JsonProperty("id_vuelo_clase")
    private int id_vuelo_clase;

    @JsonProperty("fecha_reserva")
    private Date fecha_reserva;

    @JsonProperty("total_pagado")
    private double total_pagado;

    @Enumerated(EnumType.STRING)
    @JsonProperty("estado")
    private Estado estado;

    public enum Estado {
        pendiente,
        completado
    }

    @JsonProperty("asientos_reservados")
    private String asientos_reservados;

    @JsonProperty("id_plan")
    private int id_plan;

    public Reserva() {}
}
