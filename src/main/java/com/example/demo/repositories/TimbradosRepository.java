package com.example.demo.repositories;

import com.example.demo.models.Timbrados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimbradosRepository extends JpaRepository<Timbrados, Integer> {
}
