package com.example.demo.repositories;

import com.example.demo.models.Procedencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedenciasRepository extends JpaRepository<Procedencias, Integer> {

}
