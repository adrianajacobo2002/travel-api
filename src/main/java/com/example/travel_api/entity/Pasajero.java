package com.example.travel_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pasajeros")
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_pasajero")
    private int id_pasajero;

    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false)
    @JsonProperty("reserva")
    private Reserva reserva;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("segundo_nombre")
    private String segundoNombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("fecha_nacimiento")
    private String fecha_nacimiento;

    @JsonProperty("documento_identidad")
    private String documento_identidad;

    @Enumerated(EnumType.STRING)
    @JsonProperty("genero")
    private Genero genero;

    public enum Genero {
        masculino,
        femenino,
        otro
    }

    @JsonProperty("pais_residencia")
    private String pais_residencia;

    public Pasajero() {}
}
