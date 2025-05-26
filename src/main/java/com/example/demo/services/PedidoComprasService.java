package com.example.demo.services;

import com.example.demo.models.PedidoCompras;

import java.util.List;
import java.util.Optional;

public interface PedidoComprasService {
	
	List<PedidoCompras> getAll();
	
    Optional<PedidoCompras> getById(Integer id);
    
    void save(PedidoCompras pedido);
    
    void delete(Integer id);
    
}
