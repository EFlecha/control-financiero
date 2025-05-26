package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "nacionalidades")
@Data
public class Nacionalidades {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nacionalidad")
    private Integer id;

    @Column(name = "descripcion", nullable = false, length = 80)
    private String descripcion;

}
