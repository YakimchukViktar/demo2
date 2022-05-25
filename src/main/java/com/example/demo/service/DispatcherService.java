package com.example.demo.service;

import com.example.demo.dao.model.Dispatcher;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface DispatcherService extends UserDetailsService {
    List<Dispatcher> findAllDispatchers();
    Dispatcher findDispatcherByUsername (String username);
    void save (Dispatcher dispatcher);
}
