package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "orden_compras")
@Getter
@Setter
public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden_compra")
    private Integer idOrdenCompra;

    @ManyToOne
    @JoinColumn(name = "id_presupuesto_compra", nullable = false)
    private PresupuestoCompra presupuestoCompra;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedores proveedor;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursales sucursal;

    @ManyToOne
    @JoinColumn(name = "id_condicion")
    private Condicion condicion;

    @Column(name = "observacion", length = 200)
    private String observacion;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "estado", length = 1)
    private String estado;
}

