package com.example.travel_api.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "vuelos")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_vuelo")
    private int id_vuelo;

    @ManyToOne
    @JoinColumn(name = "id_aerolinea", nullable = false)
    private Aerolinea aerolinea;

    @Column(name = "numero_vuelo", nullable = false, unique = true, length = 10)
    private String numero_vuelo;

    @ManyToOne
    @JoinColumn(name = "origen", nullable = false)
    private Aeropuerto origen;

    @ManyToOne
    @JoinColumn(name = "destino", nullable = false)
    private Aeropuerto destino;

    @Column(name = "fecha_salida", nullable = false)
    @JsonProperty("fecha_salida")
    private LocalDateTime fecha_salida;

    @Column(name = "fecha_regreso")
    @JsonProperty("fecha_regreso")
    private LocalDateTime fecha_regreso;

    @Column(name = "duracion", nullable = false)
    @JsonProperty("duracion")
    private LocalTime duracion;

    @Column(name = "precio_base", nullable = false, precision = 10, scale = 2)
    @JsonProperty("precio_base")
    private BigDecimal precio_base;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_vuelo", nullable = false)
    @JsonProperty("tipo_vuelo")
    private TipoVuelo tipo_vuelo;

    public enum TipoVuelo{
        sencillo,
        redondo
    }

    @OneToOne
    @JoinColumn(name = "id_vuelo_regreso", nullable = true)
    private Vuelo id_vuelo_regreso;

    public Vuelo() {}

}
