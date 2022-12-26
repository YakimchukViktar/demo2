package com.demo.service;

import com.demo.dao.model.Dispatcher;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface DispatcherService extends UserDetailsService {
    List<Dispatcher> findAllDispatchers();

    Dispatcher findDispatcherByUsername(String username);

    void save(Dispatcher dispatcher);

    void deleteById(Integer id);

    Dispatcher findDispatcherById(Integer id);
}
