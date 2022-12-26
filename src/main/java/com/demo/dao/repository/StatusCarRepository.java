package com.demo.dao.repository;


import com.demo.dao.model.StatusCar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusCarRepository extends CrudRepository<StatusCar, Integer> {
    List<StatusCar> findAll();

    StatusCar findStatusCarById(Integer id);
}
