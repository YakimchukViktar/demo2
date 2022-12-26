package com.demo.web.controller;

import com.demo.dao.model.*;
import com.demo.service.CarService;
import com.demo.service.DispatcherService;
import com.demo.service.DriverService;
import com.demo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class RegistrationController {

    private final DispatcherService dispatcherService;
    private final DriverService driverService;
    private final CarService carService;
    private final TripService tripService;

    @Autowired
    public RegistrationController(DispatcherService dispatcherService, DriverService driverService, CarService carService, TripService tripService) {
        this.dispatcherService = dispatcherService;
        this.driverService = driverService;
        this.carService = carService;
        this.tripService = tripService;
    }


    @ModelAttribute("dispatcher")
    public Dispatcher getEmptyDispatcher() {
        return new Dispatcher();
    }

    @GetMapping("/registerDispatcher")
    public String getRegisterPage() {
        return "registerDispatcher";
    }

    @PostMapping("/dispatcherRegister")
    public String registerDispatcher(@Valid Dispatcher dispatcher, Errors errors) {
        if (errors.hasErrors()) {
            return "registerDispatcher";
        } else {
            dispatcher.setRole(Role.ROLE_DISPATCHER);
            dispatcherService.save(dispatcher);
            return "redirect:/dispatchers/all";
        }
    }

    @GetMapping("/registerDriver")
    public String getRegisterDriverPage() {
        return "registerDriver";
    }

    @ModelAttribute("driver")
    public Driver getEmptyDriver() {
        return new Driver();
    }

    @PostMapping("/driverRegister")
    public String registerDriver(@Valid Driver driver, Errors errors) {
        if (errors.hasErrors()) {
            return "registerDriver";
        } else {
            driver.setRole(Role.ROLE_DRIVER);
            driverService.save(driver);
            return "redirect:/drivers/all";
        }
    }

    @ModelAttribute("car")
    public Car getEmptyCar() {
        return new Car();
    }

    @GetMapping("/registerCar")
    public String getRegisterCarPage() {
        return "registerCar";
    }

    @PostMapping("/carRegister")
    public String registerCar(@Valid Car car, Errors errors) {
        if (errors.hasErrors()) {
            return "registerCar";
        } else {
            carService.save(car);
            return "redirect:/cars/all";
        }
    }

    @ModelAttribute("trip")
    public Trip getEmptyTrip() {
        return new Trip();
    }

    @GetMapping("/registerTrip")
    public String getRegisterTripPage() {
        return "/registerTrip";
    }

    @PostMapping("addNewTrip")
    public String registerTrip(@Valid Trip trip, Errors errors) {
        if (errors.hasErrors()) {
            return "redirect:/registerTrip";
        } else {
            tripService.saveTrip(trip);
        }
        return "redirect:/trips/all";
    }
}
