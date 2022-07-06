package com.example.demo.service;

import com.example.demo.dao.model.Car;


public interface CarService {
    Iterable<Car> findAllCars();

    void save(Car car);


    void deleteById(Integer id);

    Car findCarById(Integer id);

}
