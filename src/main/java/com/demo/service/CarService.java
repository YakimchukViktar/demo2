package com.demo.service;

import com.demo.dao.model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAllCars();

    void save(Car car);


    void deleteById(Integer id);

    Car findCarById(Integer id);

}
