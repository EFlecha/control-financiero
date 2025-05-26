package com.example.demo.services;

import com.example.demo.models.Cajas;
import java.util.List;
import java.util.Optional;

public interface CajasService {
	
    List<Cajas> getAll();
    
    Optional<Cajas> getById(Integer id);
    
    void save(Cajas caja);
    
    void delete(Integer id);
}