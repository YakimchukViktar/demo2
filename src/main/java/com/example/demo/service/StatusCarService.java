package com.example.demo.service;

import com.example.demo.dao.model.StatusCar;


public interface StatusCarService {
    Iterable<StatusCar> findAllStatuses();

    StatusCar findStatusCarById(Integer id);

    void save(StatusCar statusCar);
}
