package com.example.demo.service;

import com.example.demo.dao.model.Dispatcher;
import com.example.demo.dao.model.Role;
import com.example.demo.dao.repository.DispatcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public Dispatcher findDispatcherByUsername(String username) {
        return dispatcherRepository.findDispatcherByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Dispatcher dispatcher = findDispatcherByUsername(username);
        Set<Role> roles = new HashSet<>();
        if (dispatcher == null)
            throw new UsernameNotFoundException("dispatcher with " + username + " doesn't exist");
        else
            System.out.println("Success");
        roles.add(dispatcher.getRole());
        return new User(username, dispatcher.getPassword(), roles);
    }
}
