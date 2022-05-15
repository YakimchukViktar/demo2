package com.example.demo.service;

import com.example.demo.dao.model.Dispatcher;
import com.example.demo.dao.repository.DispatcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatcherServiceImpl implements DispatcherService{
private final DispatcherRepository dispatcherRepository;

    @Autowired
    public DispatcherServiceImpl(DispatcherRepository dispatcherRepository) {
        this.dispatcherRepository = dispatcherRepository;
    }

    @Override
    public List<Dispatcher> findAllDispatchers() {
        return dispatcherRepository.findAll();
    }
}
