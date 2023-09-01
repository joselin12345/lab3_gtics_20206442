package com.example.lab3_20206442.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estadio")
@Getter
@Setter
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadio;

    @Column(name = "nombre", nullable = false)
    private String nombre;


    @Column(name = "provincia", nullable = false)
    private String provincia;

    @Column(name = "club", nullable = false)
    private String club;


}
