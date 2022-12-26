package com.demo.service;

import com.demo.dao.model.StatusCar;

import java.util.List;

public interface StatusCarService {
    List<StatusCar> findAllStatuses();

    StatusCar findStatusCarById(Integer id);

    void save(StatusCar statusCar);
}
