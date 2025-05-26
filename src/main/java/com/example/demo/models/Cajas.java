package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cajas")
@Data
public class Cajas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_caja")
    private Integer id;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
}
