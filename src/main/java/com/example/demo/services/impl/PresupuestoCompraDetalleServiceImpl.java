package com.example.demo.services.impl;

import com.example.demo.models.PresupuestoCompra;
import com.example.demo.models.PresupuestoCompraDetalle;
import com.example.demo.models.PresupuestoCompraDetalleId;
import com.example.demo.repositories.PresupuestoCompraDetalleRepository;
import com.example.demo.services.PresupuestoCompraDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresupuestoCompraDetalleServiceImpl implements PresupuestoCompraDetalleService {

    @Autowired
    private PresupuestoCompraDetalleRepository repository;

    @Override
    public List<PresupuestoCompraDetalle> findByPresupuesto(PresupuestoCompra presupuesto) {
        return repository.findByPresupuesto(presupuesto);
    }

    @Override
    public void save(PresupuestoCompraDetalle detalle) {
        repository.save(detalle);
    }

    @Override
    public void deleteById(PresupuestoCompraDetalleId id) {
        repository.deleteById(id);
    }
}
