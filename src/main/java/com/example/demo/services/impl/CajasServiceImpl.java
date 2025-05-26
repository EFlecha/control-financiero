package com.example.demo.services.impl;

import com.example.demo.models.Cajas;
import com.example.demo.repositories.CajasRepository;
import com.example.demo.services.CajasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CajasServiceImpl implements CajasService {
	
	@Autowired
    private CajasRepository cajasRepository;

    @Override
    public List<Cajas> getAll() {
        return cajasRepository.findAll();
    }

    @Override
    public Optional<Cajas> getById(Integer id) {
        return cajasRepository.findById(id);
    }

    @Override
    public void save(Cajas caja) {
        cajasRepository.save(caja);
    }

    @Override
    public void delete(Integer id) {
        cajasRepository.deleteById(id);
    }

}
