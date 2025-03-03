package com.example.travel_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_pago")
    private int id_pago;

    @JsonProperty("id_reserva")
    private int id_reserva;

    @JsonProperty("monto")
    private double monto;

    @Enumerated(EnumType.STRING)
    @JsonProperty("metodo_pago")
    private MetodoPago metodo_pago;

    public enum MetodoPago{
        tarjeta,
        paypal
    }

    @JsonProperty("fecha_pago")
    private Date fecha_pago;

    public Pago() {}
}
