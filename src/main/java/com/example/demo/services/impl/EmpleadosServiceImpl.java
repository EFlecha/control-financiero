package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Empleados;
import com.example.demo.repositories.EmpleadosRepository;
import com.example.demo.services.EmpleadosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmpleadosServiceImpl implements EmpleadosService {
	
	private final EmpleadosRepository empleadosRepository;

    @Override
    public List<Empleados> getAllEmpleados() {
        return empleadosRepository.findAll();
    }

    @Override
    public Optional<Empleados> getEmpleadoById(Integer id) {
        return empleadosRepository.findById(id);
    }

    @Override
    public void saveEmpleados(Empleados empleado) {
        empleadosRepository.save(empleado);
    }

    @Override
    public void deleteEmpleados(Integer id) {
        empleadosRepository.findById(id).ifPresent(empleadosRepository::delete);
    }

}
