package com.demo.service;

import com.demo.dao.model.StatusCar;


public interface StatusCarService {
    Iterable<StatusCar> findAllStatuses();

    StatusCar findStatusCarById(Integer id);

    void save(StatusCar statusCar);
}
