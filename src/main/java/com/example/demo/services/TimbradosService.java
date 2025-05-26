package com.example.demo.services;

import com.example.demo.models.Timbrados;

import java.util.List;
import java.util.Optional;

public interface TimbradosService {
    List<Timbrados> getAllTimbrados();
    Optional<Timbrados> getTimbradoById(Integer id);
    void saveTimbrado(Timbrados timbrado);
    void deleteTimbrado(Integer id);
}
