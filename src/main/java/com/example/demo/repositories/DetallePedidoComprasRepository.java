package com.example.demo.repositories;

import com.example.demo.models.DetallePedidoCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoComprasRepository extends JpaRepository<DetallePedidoCompras, Integer> {

}
