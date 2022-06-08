package com.example.demo.web.controller;

import com.example.demo.dao.model.Cargo;
import com.example.demo.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @ModelAttribute("cargo")
    public Cargo getEmptyCargo(){
        return new Cargo();
    }

    @GetMapping("/addCargo")
    public String getPageSaveNewCargo(){
        return "/addCargo";
    }

    @PostMapping("/addCargo")
    public String addNewCargo(@Valid Cargo cargo, Errors errors){
        if (errors.hasErrors()){
            return "/addCargo";
        } else {
            cargoService.saveCargo(cargo);
            return "redirect:/cargos/all";
        }
    }

    @GetMapping("/cargoDelete/{id}")
    public String deleteCargoById(@PathVariable("id") Integer id){
        cargoService.deleteById(id);
        return "redirect:/cargos/all";
    }

    @GetMapping("/editCargo/{id}")
    public String getEditCargoPage(@PathVariable("id") Integer id, Model model){
        Cargo cargoById = cargoService.findById(id);
        model.addAttribute("cargo", cargoById);
        return "/editCargo";
    }

    @PostMapping("/editCargo")
    public String editCargo (Cargo cargo){
        cargoService.saveCargo(cargo);
        return "redirect:/cargos/all";
    }
}
