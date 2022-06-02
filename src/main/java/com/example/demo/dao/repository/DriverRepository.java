package com.example.demo.dao.repository;

import com.example.demo.dao.model.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Integer> {
    List<Driver> findAll();
    Driver findDriverByUsername (String username);

}
