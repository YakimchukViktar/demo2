package com.demo.dao.repository;


import com.demo.dao.model.StatusCar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StatusCarRepository extends CrudRepository<StatusCar, Integer> {

    StatusCar findStatusCarById(Integer id);
}
