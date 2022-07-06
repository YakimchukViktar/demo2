package com.example.demo.dao.repository;

import com.example.demo.dao.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
}