package com.example.demo.service;

import com.example.demo.dao.model.StatusCar;
import com.example.demo.dao.repository.StatusCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatusCarServiceImpl implements StatusCarService {
    private final StatusCarRepository statusCarRepository;

    @Autowired
    public StatusCarServiceImpl(StatusCarRepository statusCarRepository) {
        this.statusCarRepository = statusCarRepository;
    }

    @Override
    public Iterable<StatusCar> findAllStatuses() {
        return statusCarRepository.findAll();
    }

    @Override
    public StatusCar findStatusCarById(Integer id) {
        return statusCarRepository.findStatusCarById(id);
    }

    @Override
    public void save(StatusCar statusCar) {
        statusCarRepository.save(statusCar);
    }
}
