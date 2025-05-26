package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "empleados")
@Data
public class Empleados {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id;

    @Column(name = "legajo", nullable = false, length = 15)
    private String legajo;

    @Column(name = "nombres", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellido;

    @Column(name = "cedula_identidad", nullable = false, length = 20)
    private String cedulaIdentidad;

    @Column(name = "fecha_nac", nullable = false)
    private java.sql.Date fechaNac;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_barrio", nullable = false)
    private Barrios barrio;

    @ManyToOne
    @JoinColumn(name = "id_nacionalidad", nullable = false)
    private Nacionalidades nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_estado_civil", nullable = false)
    private EstadoCivil estadoCivil;

}
