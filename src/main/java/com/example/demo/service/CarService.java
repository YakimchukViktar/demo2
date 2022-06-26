package com.example.demo.service;

import com.example.demo.dao.model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAllCars();

    void save(Car car);


    void deleteById(Integer id);

    Car findCarById(Integer id);

}
