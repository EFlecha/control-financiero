package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estado_civil")
@Data
public class EstadoCivil {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_civil")
    private Integer id;

    @Column(name = "descripcion", nullable = false, length = 80)
    private String descripcion;

}
