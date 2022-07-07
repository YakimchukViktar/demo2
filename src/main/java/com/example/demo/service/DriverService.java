package com.example.demo.service;

import com.example.demo.dao.model.Driver;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface DriverService extends UserDetailsService {
    Iterable<Driver> findAllDrivers();

    Driver findDriverByUsername(String username);

    void save(Driver driver);

    void deleteById(Integer id);

    Driver findDriverById(Integer id);

}
