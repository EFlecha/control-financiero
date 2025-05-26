package com.example.demo.repositories;

import com.example.demo.models.PresupuestoCompra;
import com.example.demo.models.PresupuestoCompraDetalle;
import com.example.demo.models.PresupuestoCompraDetalleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresupuestoCompraDetalleRepository extends JpaRepository<PresupuestoCompraDetalle, PresupuestoCompraDetalleId> {
	
	List<PresupuestoCompraDetalle> findByPresupuesto(PresupuestoCompra presupuesto);

}
