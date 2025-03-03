package com.example.travel_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_usuario")
    private int id_usuario;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("email")
    private String email;

    @JsonProperty("telefono")
    private String telefono;

    @JsonProperty("contrasena")
    private String contrasena;

    @Enumerated(EnumType.STRING)
    @JsonProperty("tipo_usuario")
    private TipoUsuario tipo_usuario;

    public Usuario() {}

    public enum TipoUsuario {
        cliente,
        admin
    }
}
