package com.example.demo.services;

import com.example.demo.models.DetallePedidoCompras;

import java.util.List;

public interface DetallePedidoComprasService {
	
	List<DetallePedidoCompras> findByPedidoId(Integer pedidoId);
	
}
