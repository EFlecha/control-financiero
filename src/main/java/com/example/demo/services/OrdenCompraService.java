package com.example.demo.services;

import com.example.demo.models.OrdenCompra;
import java.util.List;

public interface OrdenCompraService {
	
    List<OrdenCompra> getAll();
    
    OrdenCompra getById(Integer id);
    
    void save(OrdenCompra ordenCompra);
    
    void delete(Integer id);
    
}
