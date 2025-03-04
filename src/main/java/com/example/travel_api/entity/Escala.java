package com.example.travel_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "escalas")
public class Escala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_escala")
    private int id_escala;

    @ManyToOne
    @JoinColumn(name = "id_vuelo_principal", nullable = false)
    @JsonProperty("vuelo_principal")
    private Vuelo vuelo_principal;

    @ManyToOne
    @JoinColumn(name = "id_vuelo_escala", nullable = false)
    @JsonProperty("vuelo_escala")
    private Vuelo vuelo_escala;

    @Column(name = "orden_escala", nullable = false)
    @JsonProperty("orden_escala")
    private int orden_escala;

    public Escala() {}
}
