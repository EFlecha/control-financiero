package com.example.demo.services;

import com.example.demo.models.Cliente;
import java.util.List;

public interface ClienteService {
	
    List<Cliente> getAll();
    
    Cliente getById(Integer id);
    
    void save(Cliente cliente);
    
    void delete(Integer id);
    
}

