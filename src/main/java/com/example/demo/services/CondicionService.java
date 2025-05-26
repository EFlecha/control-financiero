package com.example.demo.services;

import com.example.demo.models.Condicion;
import java.util.List;

public interface CondicionService {
    
	List<Condicion> getAll();
    
	void save(Condicion condicion);
    
	Condicion getById(Integer id);
    
	void deleteById(Integer id);
}