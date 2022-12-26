package com.demo.service;

import com.demo.dao.model.Dispatcher;
import com.demo.dao.model.Role;
import com.demo.dao.repository.DispatcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DispatcherServiceImpl implements DispatcherService {
    private final DispatcherRepository dispatcherRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DispatcherServiceImpl(DispatcherRepository dispatcherRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.dispatcherRepository = dispatcherRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
    public void save(Dispatcher dispatcher) {
        dispatcher.setPassword(bCryptPasswordEncoder.encode(dispatcher.getPassword()));
        dispatcherRepository.save(dispatcher);
    }

    @Override
    public void deleteById(Integer id) {
        dispatcherRepository.deleteById(id);
    }

    @Override
    public Dispatcher findDispatcherById(Integer id) {
        return dispatcherRepository.findDispatcherById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Dispatcher dispatcher = findDispatcherByUsername(username);
        Set<Role> roles = new HashSet<>();
        if (dispatcher == null) {
            throw new UsernameNotFoundException("dispatcher with " + username + " doesn't exist");
        } else {
            System.out.println("Dispatcher was successfully found");
        }
        roles.add(dispatcher.getRole());
        return new User(username, dispatcher.getPassword(), roles);
    }
}
