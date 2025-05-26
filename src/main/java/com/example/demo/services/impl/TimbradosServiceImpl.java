package com.example.demo.services.impl;

import com.example.demo.models.Timbrados;
import com.example.demo.repositories.TimbradosRepository;
import com.example.demo.services.TimbradosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimbradosServiceImpl implements TimbradosService {

    @Autowired
    private TimbradosRepository timbradosRepository;

    @Override
    public List<Timbrados> getAllTimbrados() {
        return timbradosRepository.findAll();
    }

    @Override
    public Optional<Timbrados> getTimbradoById(Integer id) {
        return timbradosRepository.findById(id);
    }

    @Override
    public void saveTimbrado(Timbrados timbrado) {
        timbradosRepository.save(timbrado);
    }

    @Override
    public void deleteTimbrado(Integer id) {
        timbradosRepository.deleteById(id);
    }
}

