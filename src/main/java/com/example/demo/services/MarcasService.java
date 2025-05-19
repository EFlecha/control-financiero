package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Marcas;

public interface MarcasService {
	
	List<Marcas> getAllMarcas();

    Optional<Marcas> getMarcaById(Integer id);

    void saveMarcas(Marcas marca);

    void deleteMarcas(Integer id);
}
