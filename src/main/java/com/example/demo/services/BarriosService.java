package com.example.demo.services;

import com.example.demo.models.Barrios;

import java.util.List;
import java.util.Optional;

public interface BarriosService {
	
	List<Barrios> getAllBarrios();
    Optional<Barrios> getBarrioById(Integer id);
    void saveBarrios(Barrios barrio);
    void deleteBarrios(Integer id);

}
