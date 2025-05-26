package com.example.demo.repositories;

import com.example.demo.models.TipoImpuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoImpuestoRepository extends JpaRepository<TipoImpuesto, Integer> {

}
