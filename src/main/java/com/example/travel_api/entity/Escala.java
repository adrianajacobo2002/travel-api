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

    @JsonProperty("id_vuelo_principal")
    private int id_vuelo_principal;

    @JsonProperty("id_vuelo_escala")
    private int id_vuelo_escala;

    @JsonProperty("orden_escala")
    private int orden_escala;

    public Escala() {}
}
