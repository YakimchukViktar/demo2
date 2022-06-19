package com.example.demo.web.controller;

import com.example.demo.dao.model.Dispatcher;
import com.example.demo.service.DispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class DispatcherController {
    private final DispatcherService dispatcherService;

    @Autowired
    public DispatcherController(DispatcherService dispatcherService) {
        this.dispatcherService = dispatcherService;
    }

    @GetMapping("/dispatchers/all")
    public String getAllDispatchers(Model model){
        List<Dispatcher> dispatchers = dispatcherService.findAllDispatchers();
        model.addAttribute("dispatchers",dispatchers);
        return "dispatchers";
    }

    @GetMapping("/deleteDispatcher/{id}")
    public String deleteDispatcherById (@PathVariable("id") Integer id){
        dispatcherService.deleteById(id);
        return "redirect:/dispatchers/all";
    }
}
