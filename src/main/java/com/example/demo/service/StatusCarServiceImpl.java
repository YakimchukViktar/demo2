package com.example.demo.service;

import com.example.demo.dao.model.StatusCar;
import com.example.demo.dao.repository.StatusCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusCarServiceImpl implements StatusCarService{
private final StatusCarRepository statusCarRepository;

    @Autowired
    public StatusCarServiceImpl(StatusCarRepository statusCarRepository) {
        this.statusCarRepository = statusCarRepository;
    }

    @Override
    public List<StatusCar> findAllStatuses() {
        return statusCarRepository.findAll();
    }

    @Override
    public StatusCar findStatusCarById(Integer id) {
        return statusCarRepository.findStatusCarById(id);
    }


}
