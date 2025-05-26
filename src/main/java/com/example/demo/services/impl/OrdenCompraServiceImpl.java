package com.example.demo.services.impl;

import com.example.demo.models.OrdenCompra;
import com.example.demo.repositories.OrdenCompraRepository;
import com.example.demo.services.OrdenCompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

    @Autowired
    private OrdenCompraRepository repository;

    @Override
    public List<OrdenCompra> getAll() {
        return repository.findAll();
    }

    @Override
    public OrdenCompra getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(OrdenCompra ordenCompra) {
        repository.save(ordenCompra);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
