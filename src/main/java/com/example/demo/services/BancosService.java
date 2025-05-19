package com.example.demo.services;

import com.example.demo.models.Bancos;

import java.util.List;
import java.util.Optional;

public interface BancosService {

    List<Bancos> getAllBancos();

    Optional<Bancos> getBancoById(Integer id);

    void saveBancos(Bancos banco);

    void deleteBancos(Integer id);
}
