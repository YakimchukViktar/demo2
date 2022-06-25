package com.example.demo.dao.repository;

import com.example.demo.dao.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
    List<Car> findAll();

    void deleteById(Integer id);
}