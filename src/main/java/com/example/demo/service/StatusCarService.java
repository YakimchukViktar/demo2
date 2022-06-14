package com.example.demo.service;

import com.example.demo.dao.model.StatusCar;

import java.util.List;
import java.util.Optional;

public interface StatusCarService {
    List<StatusCar> findAllStatuses ();
    StatusCar findStatusCarById (Integer id);

    void save (StatusCar statusCar);
}
