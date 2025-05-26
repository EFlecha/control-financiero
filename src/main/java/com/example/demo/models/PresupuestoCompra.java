package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "presupuesto_compras")
@Getter
@Setter
public class PresupuestoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presupuesto_compra")
    private Integer id_presupuesto_compra;

    @ManyToOne
    @JoinColumn(name = "id_pedido_compra", nullable = false)
    private PedidoCompras pedidoCompra;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedores proveedor;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursales sucursal;

    @Column(name = "observacion", length = 200)
    private String observacion;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "estado", length = 1)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_condicion")
    private Condicion condicion;
}