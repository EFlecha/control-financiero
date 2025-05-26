package com.example.demo.services;

import com.example.demo.models.TipoImpuesto;
import java.util.List;

public interface TipoImpuestoService {
	
    List<TipoImpuesto> getAll();
    
    void save(TipoImpuesto tipoImpuesto);
    
    TipoImpuesto getById(Integer id);
    
    void deleteById(Integer id);
}
