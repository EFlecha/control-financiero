package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "presupuesto_compras_detalle")
@Getter
@Setter
public class PresupuestoCompraDetalle {

    @EmbeddedId
    private PresupuestoCompraDetalleId id;

    @ManyToOne
    @JoinColumn(name = "id_presupuesto_compra", insertable = false, updatable = false)
    private PresupuestoCompra presupuesto;

    @ManyToOne
    @JoinColumn(name = "id_mercaderia", insertable = false, updatable = false)
    private Mercaderias mercaderia;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio_compra")
    private Integer precioCompra;
}
