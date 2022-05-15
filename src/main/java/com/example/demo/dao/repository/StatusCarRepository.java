package com.example.demo.dao.repository;


import com.example.demo.dao.model.StatusCar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatusCarRepository extends CrudRepository<StatusCar, Integer> {
    List<StatusCar> findAll();
    StatusCar findStatusCarById (Integer id);
}
