package com.example.demo.services.impl;

import com.example.demo.models.TipoImpuesto;
import com.example.demo.repositories.TipoImpuestoRepository;
import com.example.demo.services.TipoImpuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoImpuestoServiceImpl implements TipoImpuestoService {
	
    @Autowired
    private TipoImpuestoRepository tipoImpuestoRepository;

    @Override
    public List<TipoImpuesto> getAll() {
        return tipoImpuestoRepository.findAll();
    }

    @Override
    public void save(TipoImpuesto tipoImpuesto) {
        tipoImpuestoRepository.save(tipoImpuesto);
    }

    @Override
    public TipoImpuesto getById(Integer id) {
        Optional<TipoImpuesto> optional = tipoImpuestoRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        tipoImpuestoRepository.deleteById(id);
    }
}
