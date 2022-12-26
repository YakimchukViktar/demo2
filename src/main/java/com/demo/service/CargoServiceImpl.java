package com.demo.service;

import com.demo.dao.model.Cargo;
import com.demo.dao.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {
    private final CargoRepository cargoRepository;

    @Autowired
    public CargoServiceImpl(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public List<Cargo> findAllCargos() {
        return cargoRepository.findAll();
    }

    @Override
    public void saveCargo(Cargo cargo) {
        cargoRepository.save(cargo);
    }

    @Override
    public void deleteById(Integer id) {
        cargoRepository.deleteById(id);
    }

    @Override
    public Cargo findById(Integer id) {
        return cargoRepository.findById(id).orElse(null);
    }
}
