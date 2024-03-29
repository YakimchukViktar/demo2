package com.demo.web.controller;

import com.demo.dao.model.Driver;
import com.demo.dao.model.Role;
import com.demo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@Controller
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/drivers/all")
    public String getlAllDrivers(Model model) {
        Iterable<Driver> allDrivers = driverService.findAllDrivers();
        model.addAttribute("drivers", allDrivers);
        return "drivers";
    }

    @GetMapping("/driverDelete/{id}")
    public String deleteDriverById(@PathVariable("id") Integer id) {
        driverService.deleteById(id);
        return "redirect:/drivers/all";
    }

    @GetMapping("/editDriver/{id}")
    public String getEditDriverPage(@PathVariable("id") Integer id, Model model) {
        Driver driver = driverService.findDriverById(id);
        model.addAttribute("driver", driver);
        return "/editDriver";
    }

    @PostMapping("/editDriver")
    public String editDriver(Driver driver) {
        driver.setRole(Role.ROLE_DRIVER);
        driverService.save(driver);
        return "redirect:/drivers/all";
    }
}
