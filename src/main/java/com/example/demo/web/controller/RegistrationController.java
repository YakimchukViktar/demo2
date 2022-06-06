package com.example.demo.web.controller;

import com.example.demo.dao.model.Car;
import com.example.demo.dao.model.Dispatcher;
import com.example.demo.dao.model.Driver;
import com.example.demo.dao.model.Role;
import com.example.demo.service.CarService;
import com.example.demo.service.DispatcherService;
import com.example.demo.service.DriverService;
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

    @Autowired
    public RegistrationController(DispatcherService dispatcherService, DriverService driverService, CarService carService) {
        this.dispatcherService = dispatcherService;
        this.driverService = driverService;
        this.carService = carService;
    }


    @ModelAttribute("dispatcher")
    public Dispatcher getEmptyDispatcher (){
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
            return "/login";
        }
    }

    @GetMapping("/registerDriver")
    public String getRegisterDriverPage(){
        return "registerDriver";
    }

    @ModelAttribute("driver")
    public Driver getEmptyDriver (){
        return new Driver();
    }

    @PostMapping("/driverRegister")
    public String registerDriver(@Valid Driver driver, Errors errors){
        if (errors.hasErrors()){
            return "registerDriver";
        } else {
            driver.setRole(Role.ROLE_DRIVER);
            driverService.save(driver);
            return "/login";
        }
    }

    @ModelAttribute("car")
    public Car getEmptyCar(){
        return new Car();
    }

    @GetMapping("/registerCar")
    public String getRegisterCarPage(){
        return "registerCar";
    }

    @PostMapping("/carRegister")
    public String registerCar(@Valid Car car, Errors errors){
        if (errors.hasErrors()){
            return "registerCar";
        } else {
            carService.save(car);
            return "redirect:/cars/all";
        }
    }
}
