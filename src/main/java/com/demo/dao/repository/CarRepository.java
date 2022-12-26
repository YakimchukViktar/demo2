package com.demo.dao.repository;

import com.demo.dao.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
}