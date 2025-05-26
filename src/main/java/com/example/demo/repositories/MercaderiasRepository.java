package com.example.demo.repositories;

import com.example.demo.models.Mercaderias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercaderiasRepository extends JpaRepository<Mercaderias, Integer> {

}
