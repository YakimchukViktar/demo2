package com.example.demo.service;

import com.example.demo.dao.model.Dispatcher;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface DispatcherService extends UserDetailsService {
    Iterable<Dispatcher> findAllDispatchers();

    Dispatcher findDispatcherByUsername(String username);

    void save(Dispatcher dispatcher);

    void deleteById(Integer id);

    Dispatcher findDispatcherById(Integer id);
}
