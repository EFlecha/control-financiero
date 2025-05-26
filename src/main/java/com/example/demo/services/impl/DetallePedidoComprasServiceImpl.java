package com.example.demo.services.impl;

import java.util.List;

import com.example.demo.models.DetallePedidoCompras;
import com.example.demo.repositories.DetallePedidoComprasRepository;
import com.example.demo.services.DetallePedidoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoComprasServiceImpl implements DetallePedidoComprasService {
	
	@Autowired
    private DetallePedidoComprasRepository detalleRepo;

    @Override
    public List<DetallePedidoCompras> findByPedidoId(Integer pedidoId) {
        return detalleRepo.findAll().stream()
                .filter(detalle -> detalle.getPedido().getId().equals(pedidoId))
                .toList();
    }
}
