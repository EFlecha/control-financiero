package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.PedidoCompras;
import com.example.demo.repositories.PedidoComprasRepository;
import com.example.demo.services.PedidoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoComprasServiceImpl implements PedidoComprasService {

	@Autowired
    private PedidoComprasRepository repository;

    @Override
    public List<PedidoCompras> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PedidoCompras> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void save(PedidoCompras pedido) {
        repository.save(pedido);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
