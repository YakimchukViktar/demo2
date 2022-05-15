package com.example.demo.service;

import com.example.demo.dao.model.Driver;

import java.util.List;

public interface DriverService {
    List<Driver> findAllDrivers();
}
