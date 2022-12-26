package com.demo.web.controller;

import com.demo.dao.model.Dispatcher;
import com.demo.dao.model.Role;
import com.demo.service.DispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DispatcherController {
    private final DispatcherService dispatcherService;

    @Autowired
    public DispatcherController(DispatcherService dispatcherService) {
        this.dispatcherService = dispatcherService;
    }

    @GetMapping("/dispatchers/all")
    public String getAllDispatchers(Model model) {
        Iterable<Dispatcher> dispatchers = dispatcherService.findAllDispatchers();
        model.addAttribute("dispatchers", dispatchers);
        return "dispatchers";
    }

    @GetMapping("/deleteDispatcher/{id}")
    public String deleteDispatcherById(@PathVariable("id") Integer id) {
        dispatcherService.deleteById(id);
        return "redirect:/dispatchers/all";
    }


    @GetMapping("/editDispatcher/{id}")
    public String getEditDispatcherPage(@PathVariable("id") Integer id, Model model) {
        Dispatcher dispatcher = dispatcherService.findDispatcherById(id);
        model.addAttribute("dispatcher", dispatcher);
        return "editDispatcher";
    }

    @PostMapping("/editDispatcher")
    public String editDispatcher(Dispatcher dispatcher) {
        dispatcher.setRole(Role.ROLE_DISPATCHER);
        dispatcherService.save(dispatcher);
        return "redirect:/dispatchers/all";
    }

}
