package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Marcas;
import com.example.demo.repositories.MarcasRepository;
import com.example.demo.services.MarcasService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MarcasServiceImpl implements MarcasService {
	
	private final MarcasRepository marcasRepository;
	
	@Override
	public List<Marcas> getAllMarcas() {
		return this.marcasRepository.findAll();
	}

    @Override
    public Optional<Marcas> getMarcaById(Integer id) {
        return this.marcasRepository.findById(id);
    }

    @Override
    public void saveMarcas(Marcas marca) {
        this.marcasRepository.save(marca);
    }

    @Override
    public void deleteMarcas(Integer id) {
        this.marcasRepository.findById(id).ifPresent(marca -> this.marcasRepository.delete(marca));
    }

}
