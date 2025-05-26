package com.example.demo.repositories;

import com.example.demo.models.Cajas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CajasRepository extends JpaRepository<Cajas, Integer> {
	
}
