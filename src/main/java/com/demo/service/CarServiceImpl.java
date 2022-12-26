package com.demo.service;

import com.demo.dao.model.Car;
import com.demo.dao.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteById(Integer id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car findCarById(Integer id) {
        return carRepository.findById(id).orElse(null);
    }

}
