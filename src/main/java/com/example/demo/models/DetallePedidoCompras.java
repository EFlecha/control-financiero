package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "detalle_pedido_compras")
public class DetallePedidoCompras {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_pedido_compra")
    private PedidoCompras pedido;

    @ManyToOne
    @JoinColumn(name = "id_mercaderia")
    private Mercaderias mercaderia;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private BigDecimal precioUnitario;

}
