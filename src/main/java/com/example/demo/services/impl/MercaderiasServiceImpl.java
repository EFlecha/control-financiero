package com.example.demo.services.impl;

import com.example.demo.models.Mercaderias;
import com.example.demo.repositories.MercaderiasRepository;
import com.example.demo.services.MercaderiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercaderiasServiceImpl implements MercaderiasService {

	@Autowired
    private MercaderiasRepository mercaderiasRepository;

    @Override
    public List<Mercaderias> getAllMercaderias() {
        return mercaderiasRepository.findAll();
    }

    @Override
    public Optional<Mercaderias> getMercaderiaById(Integer id) {
        return mercaderiasRepository.findById(id);
    }

    @Override
    public void saveMercaderia(Mercaderias mercaderia) {
        mercaderiasRepository.save(mercaderia);
    }

    @Override
    public void deleteMercaderia(Integer id) {
        mercaderiasRepository.deleteById(id);
    }

}
