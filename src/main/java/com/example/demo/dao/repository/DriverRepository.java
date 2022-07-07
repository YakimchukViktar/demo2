package com.example.demo.dao.repository;

import com.example.demo.dao.model.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DriverRepository extends CrudRepository<Driver, Integer> {

    Driver findDriverByUsername(String username);

    Driver findDriverById(Integer id);
}
