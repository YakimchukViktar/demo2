package com.example.demo.web.controller;

import com.example.demo.dao.model.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/all")
    public String getAllCars(Model model) {
        Iterable<Car> allCars = carService.findAllCars();
        model.addAttribute("cars", allCars);
        return "cars";
    }

    @GetMapping("/carDelete/{id}")
    public String deleteCar(@PathVariable("id") Integer id) {
        carService.deleteById(id);
        return "redirect:/cars/all";
    }

    @GetMapping("/editCar/{id}")
    public String getEditCarPage(@PathVariable("id") Integer id, Model model) {
        Car car = carService.findCarById(id);
        model.addAttribute("car", car);
        return "/editCar";
    }

    @PostMapping("/editCar")
    public String updateCar(Car car) {
        carService.save(car);
        return "redirect:/cars/all";
    }
}
