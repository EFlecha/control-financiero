package com.example.demo.services.impl;

import com.example.demo.models.Proveedores;
import com.example.demo.repositories.ProveedoresRepository;
import com.example.demo.services.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {

	@Autowired
    private ProveedoresRepository proveedoresRepository;

    @Override
    public List<Proveedores> getAllProveedores() {
        return proveedoresRepository.findAll();
    }

    @Override
    public Optional<Proveedores> getProveedorById(Integer id) {
        return proveedoresRepository.findById(id);
    }

    @Override
    public void saveProveedor(Proveedores proveedor) {
        proveedoresRepository.save(proveedor);
    }

    @Override
    public void deleteProveedor(Integer id) {
        proveedoresRepository.deleteById(id);
    }

}
