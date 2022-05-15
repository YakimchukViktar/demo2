package com.example.demo.web.controller;

import com.example.demo.dao.model.Car;
import com.example.demo.dao.model.StatusCar;
import com.example.demo.service.StatusCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Controller
public class StatusCarController {
    private final StatusCarService statusCarService;

    @Autowired
    public StatusCarController(StatusCarService statusCarService) {
        this.statusCarService = statusCarService;
    }

    @GetMapping("/statusCar/all")
    public String getAllStatusesOfCars(Model model){
        List<StatusCar> allStatuses = statusCarService.findAllStatuses();
        model.addAttribute("statusesCars", allStatuses);
        return "statusCar";
    }

    @GetMapping("cars/{idStatus}")
    public String getCarsByIdStatus(Model model, @PathVariable("idStatus") Integer id){
        StatusCar statusCarById = statusCarService.findStatusCarById(id);
        model.addAttribute("carWithStatus", statusCarById);
        return "cars";
    }
}
