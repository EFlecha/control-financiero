package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "timbrados")
@Getter
@Setter
public class Timbrados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_timbrado")
    private Integer id;

    @Column(name = "nro_desde", nullable = false)
    private Integer nroDesde;

    @Column(name = "nro_hasta", nullable = false)
    private Integer nroHasta;

    @Column(name = "nro3", nullable = false)
    private Integer nro3;

    @Column(name = "nro_timbrado", nullable = false)
    private Integer nroTimbrado;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumento tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "nro1")
    private Sucursales sucursal;

    @ManyToOne
    @JoinColumn(name = "nro2")
    private Cajas caja;

    @Column(name = "estado", length = 3)
    private String estado;
}

