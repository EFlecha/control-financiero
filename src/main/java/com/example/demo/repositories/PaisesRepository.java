package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Paises;


public interface PaisesRepository extends JpaRepository<Paises, Integer> {

}
