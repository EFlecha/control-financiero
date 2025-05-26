package com.example.demo.services;

import com.example.demo.models.OrdenCompraDetalle;
import com.example.demo.models.OrdenCompraDetalleId;

import java.util.List;

public interface OrdenCompraDetalleService {
    List<OrdenCompraDetalle> getByOrdenCompraId(Integer idOrdenCompra);
    void save(OrdenCompraDetalle detalle);
    void delete(OrdenCompraDetalleId id);
}