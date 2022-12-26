package com.demo.service;

import com.demo.dao.model.Cargo;

import java.util.List;

public interface CargoService {
    List<Cargo> findAllCargos();

    void saveCargo(Cargo cargo);

    void deleteById(Integer id);

    Cargo findById(Integer id);
}
