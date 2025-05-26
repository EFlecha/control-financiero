package com.example.demo.services.impl;

import com.example.demo.models.OrdenCompraDetalle;
import com.example.demo.repositories.OrdenCompraDetalleRepository;
import com.example.demo.models.OrdenCompraDetalleId;
import com.example.demo.services.OrdenCompraDetalleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class OrdenCompraDetalleServiceImpl implements OrdenCompraDetalleService {

	@Autowired
    private OrdenCompraDetalleRepository repository;

    @Override
    public List<OrdenCompraDetalle> getByOrdenCompraId(Integer idOrdenCompra) {
        return repository.findByOrdenCompraIdOrdenCompra(idOrdenCompra);
    }

    @Override
    public void save(OrdenCompraDetalle detalle) {
        repository.save(detalle);
    }

    @Override
    public void delete(OrdenCompraDetalleId id) {
        repository.deleteById(id);
    }

}
