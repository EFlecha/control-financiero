package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Condicion;
import com.example.demo.repositories.CondicionRepository;
import com.example.demo.services.CondicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondicionServiceImpl implements CondicionService {

	@Autowired
    private CondicionRepository repository;

    @Override
    public List<Condicion> getAll() {
        return repository.findAll();
    }
    
    @Override
    public void save(Condicion condicion) {
    	repository.save(condicion);
    }

    @Override
    public Condicion getById(Integer id) {
        Optional<Condicion> opt = repository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
    	repository.deleteById(id);
    }

}
