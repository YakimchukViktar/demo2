package com.demo.service;

import com.demo.dao.model.Driver;
import com.demo.dao.model.Role;
import com.demo.dao.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.driverRepository = driverRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Iterable<Driver> findAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver findDriverByUsername(String username) {
        return driverRepository.findDriverByUsername(username);
    }

    @Override
    public void save(Driver driver) {
        driver.setPassword(bCryptPasswordEncoder.encode(driver.getPassword()));
        driverRepository.save(driver);
    }

    @Override
    public void deleteById(Integer id) {
        driverRepository.deleteById(id);
    }

    @Override
    public Driver findDriverById(Integer id) {
        return driverRepository.findDriverById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Driver driver = findDriverByUsername(username);
        Set<Role> roles = new HashSet<>();
        if (driver == null) {
            throw new UsernameNotFoundException("Driver with " + username + " doesn't exist");
        } else System.out.println("Driver was successfully found");
        roles.add(driver.getRole());
        return new User(username, driver.getPassword(), roles);
    }
}
