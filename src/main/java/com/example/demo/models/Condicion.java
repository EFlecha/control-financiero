package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "condicion")
@Data
public class Condicion {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_condicion")
    private Integer id_condicion;

    @Column(name = "descripcion", length = 50)
    private String descripcion;

    @Column(name = "cuota")
    private Integer cuota;

}
