package com.example.demo.services;

import com.example.demo.models.PresupuestoCompra;
import java.util.List;

public interface PresupuestoCompraService {
    List<PresupuestoCompra> getAll();
    PresupuestoCompra getById(Integer id);
    void save(PresupuestoCompra presupuesto);
    void deleteById(Integer id);
}

