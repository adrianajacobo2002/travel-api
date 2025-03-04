package com.example.travel_api.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_reserva")
    private int id_reserva;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonProperty("usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_vuelo_clase", nullable = false)
    @JsonProperty("vueloClase")
    private VueloClase vueloClase;

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

    @ElementCollection
    @CollectionTable(name = "asientos_reservados", joinColumns = @JoinColumn(name = "id_reserva"))
    @Column(name = "asientos_reservados")
    @JsonProperty("asientos_reservados")
    private List<String> asientos_reservados;

    @JsonProperty("id_plan")
    private int id_plan;

    public Reserva() {}
}
