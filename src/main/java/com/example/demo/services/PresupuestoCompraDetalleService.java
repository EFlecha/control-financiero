package com.example.demo.services;

import com.example.demo.models.PresupuestoCompra;
import com.example.demo.models.PresupuestoCompraDetalle;
import com.example.demo.models.PresupuestoCompraDetalleId;

import java.util.List;

public interface PresupuestoCompraDetalleService {
	List<PresupuestoCompraDetalle> findByPresupuesto(PresupuestoCompra presupuesto);
    void save(PresupuestoCompraDetalle detalle);
    void deleteById(PresupuestoCompraDetalleId id);
}
