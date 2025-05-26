package com.example.demo.repositories;

import com.example.demo.models.OrdenCompraDetalle;
import com.example.demo.models.OrdenCompraDetalleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenCompraDetalleRepository extends JpaRepository<OrdenCompraDetalle, OrdenCompraDetalleId> {

    List<OrdenCompraDetalle> findByOrdenCompraIdOrdenCompra(Integer idOrdenCompra);
}
