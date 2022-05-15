package com.example.demo.web.controller;

import com.example.demo.dao.model.Cargo;
import com.example.demo.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CargoController {
    private final CargoService cargoService;

    @Autowired
    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping("/cargos/all")
    public String getAllCargos(Model model){
        List<Cargo> allCargos = cargoService.findAllCargos();
        model.addAttribute("cargos", allCargos);
        return "cargos";
    }
}
