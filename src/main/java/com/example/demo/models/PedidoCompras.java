package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "pedido_compras")
public class PedidoCompras {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_compra")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedores proveedor;

    @Column(name = "observacion", length = 200)
    private String observacion;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "estado", length = 1)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursales sucursal;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    @ManyToOne
    @JoinColumn(name = "id_condicion")
    private Condicion condicion;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedidoCompras> detalles;

}
