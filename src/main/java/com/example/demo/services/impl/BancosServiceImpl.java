package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Bancos;
import com.example.demo.repositories.BancosRepository;
import com.example.demo.services.BancosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BancosServiceImpl implements BancosService {
	
	private final BancosRepository bancosRepository;

    @Override
    public List<Bancos> getAllBancos() {
        return bancosRepository.findAll();
    }

    @Override
    public Optional<Bancos> getBancoById(Integer id) {
        return bancosRepository.findById(id);
    }

    @Override
    public void saveBancos(Bancos banco) {
        bancosRepository.save(banco);
    }

    @Override
    public void deleteBancos(Integer id) {
        bancosRepository.findById(id).ifPresent(banco -> bancosRepository.delete(banco));
    }

}
