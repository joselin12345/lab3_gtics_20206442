package com.example.lab3_20206442.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jugador")
@Getter
@Setter
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJugador;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private  Integer edad;

    @Column(name = "posicion", nullable = false)
    private String posicion;

    @Column(name = "club", nullable = false)
    private String club;

    @Column(name = "sn_idSeleccion", nullable = false)
    private Integer sn_idSeleccion;
}
