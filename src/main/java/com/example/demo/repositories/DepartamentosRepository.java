package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Departamentos;

public interface DepartamentosRepository extends JpaRepository<Departamentos, Integer> {

}
