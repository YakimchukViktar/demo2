package com.example.demo.web.controller;

import com.example.demo.dao.model.Driver;
import com.example.demo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/drivers/all")
    public String getlAllDrivers(Model model){
        List<Driver> allDrivers = driverService.findAllDrivers();
        model.addAttribute("drivers", allDrivers);
        return "drivers";
    }
}
