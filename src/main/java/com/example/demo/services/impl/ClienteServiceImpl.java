package com.example.demo.services.impl;

import com.example.demo.models.Cliente;
import com.example.demo.services.ClienteService;
import com.example.demo.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public Cliente getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
