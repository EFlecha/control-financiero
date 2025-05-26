package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orden_compras_detalle")
@IdClass(OrdenCompraDetalleId.class)
@Getter
@Setter
public class OrdenCompraDetalle {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_orden_compra")
    private OrdenCompra ordenCompra;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_mercaderia")
    private Mercaderias mercaderia;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio_compra")
    private Integer precioCompra;
}

