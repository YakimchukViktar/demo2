package com.example.demo.web.controller;

import com.example.demo.dao.model.Cargo;
import com.example.demo.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/cargo")
    public String getCargoByIdCargo(@RequestParam("id") int id, Model model){
        List<Cargo> allCargos = cargoService.findAllCargos();
        Cargo cargo = allCargos.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        model.addAttribute("cargo", cargo);
        return "cargos";
    }
}
