package com.example.demo.services.impl;

import com.example.demo.models.PresupuestoCompra;
import com.example.demo.repositories.PresupuestoCompraRepository;
import com.example.demo.services.PresupuestoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresupuestoCompraServiceImpl implements PresupuestoCompraService {

    @Autowired
    private PresupuestoCompraRepository repository;

    @Override
    public List<PresupuestoCompra> getAll() {
        return repository.findAll();
    }

    @Override
    public PresupuestoCompra getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(PresupuestoCompra presupuesto) {
        repository.save(presupuesto);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}

