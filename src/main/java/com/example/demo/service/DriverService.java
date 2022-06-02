package com.example.demo.service;

import com.example.demo.dao.model.Driver;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface DriverService extends UserDetailsService {
    List<Driver> findAllDrivers();
    Driver findDriverByUsername (String username);
    void save (Driver driver);
}
