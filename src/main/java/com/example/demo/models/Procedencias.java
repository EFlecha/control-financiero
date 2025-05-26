package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "procedencias")
@Getter
@Setter
public class Procedencias {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_procedencia")
    private Integer id_procedencia;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
}
