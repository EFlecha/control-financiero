package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id_cliente;

    @ManyToOne
    @JoinColumn(name = "id_barrio", nullable = false)
    private Barrios barrio;

    @Column(name = "razon_social", nullable = false, length = 100)
    private String razon_social;

    @Column(name = "ruc", nullable = false, length = 20, unique = true)
    private String ruc;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "tipo_cliente", length = 3)
    private String tipo_cliente;
}
