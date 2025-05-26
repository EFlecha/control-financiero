package com.example.demo.repositories;

import com.example.demo.models.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {
	
    // Métodos adicionales si fueran necesarios
	
}
