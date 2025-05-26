package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "mercaderias")
@Getter
@Setter
public class Mercaderias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mercaderia")
    private Integer id_mercaderia;

    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marcas marca;

    @ManyToOne
    @JoinColumn(name = "id_tipo_impuesto", nullable = false)
    private TipoImpuesto tipoImpuesto;

    @ManyToOne
    @JoinColumn(name = "id_procedencia")
    private Procedencias procedencia;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @Column(name = "afecta_existencia", nullable = false, length = 1)
    private String afectaExistencia;

    @Column(name = "precio_compra", nullable = false, precision = 12, scale = 0)
    private BigDecimal precioCompra;

    @Column(name = "precio_venta", nullable = false, precision = 12, scale = 0)
    private BigDecimal precioVenta;
}
