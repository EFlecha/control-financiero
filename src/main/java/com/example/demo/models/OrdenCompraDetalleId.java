package com.example.demo.models;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class OrdenCompraDetalleId implements Serializable {
	
    private Integer ordenCompra;
    
    private Integer mercaderia;
}
