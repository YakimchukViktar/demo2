package com.demo.service;

import com.demo.dao.model.Car;


public interface CarService {
    Iterable<Car> findAllCars();

    void save(Car car);


    void deleteById(Integer id);

    Car findCarById(Integer id);

}
