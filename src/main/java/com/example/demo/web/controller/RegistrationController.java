package com.example.demo.web.controller;

import com.example.demo.dao.model.Dispatcher;
import com.example.demo.dao.model.Driver;
import com.example.demo.dao.model.Role;
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

    @Autowired
    public RegistrationController(DispatcherService dispatcherService, DriverService driverService) {
        this.dispatcherService = dispatcherService;
        this.driverService = driverService;
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
}
