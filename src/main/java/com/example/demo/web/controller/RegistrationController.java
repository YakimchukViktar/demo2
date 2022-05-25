package com.example.demo.web.controller;

import com.example.demo.dao.model.Dispatcher;
import com.example.demo.dao.model.Role;
import com.example.demo.service.DispatcherService;
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

    @Autowired
    public RegistrationController(DispatcherService dispatcherService) {
        this.dispatcherService = dispatcherService;
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
}
