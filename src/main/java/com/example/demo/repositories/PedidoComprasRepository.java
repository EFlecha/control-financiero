package com.example.demo.repositories;

import com.example.demo.models.PedidoCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoComprasRepository extends JpaRepository<PedidoCompras, Integer> {

}
