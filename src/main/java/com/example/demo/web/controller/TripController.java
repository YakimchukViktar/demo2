package com.example.demo.web.controller;

import com.example.demo.dao.model.Dispatcher;
import com.example.demo.dao.model.Driver;
import com.example.demo.dao.model.Role;
import com.example.demo.dao.model.Trip;
import com.example.demo.service.DispatcherService;
import com.example.demo.service.DriverService;
import com.example.demo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class TripController {
    private final TripService tripService;
    private final DriverService driverService;
    private final DispatcherService dispatcherService;

    @Autowired
    public TripController(TripService tripService, DriverService driverService, DispatcherService dispatcherService) {
        this.tripService = tripService;
        this.driverService = driverService;
        this.dispatcherService = dispatcherService;
    }

    @GetMapping("/trips/all")
    public String getAllTrips(Model model, Principal principal) {
        List<Trip> allTrips = new ArrayList<>();
        Driver driverByUsername = driverService.findDriverByUsername(principal.getName());
        Dispatcher dispatcherByUsername = dispatcherService.findDispatcherByUsername(principal.getName());
        Role role = null;
        if (driverByUsername == null) {
            role = dispatcherByUsername.getRole();
        } else if (dispatcherByUsername == null) {
            role = driverByUsername.getRole();
        }
        if (role == Role.ROLE_ADMIN || role == Role.ROLE_DISPATCHER) {
            allTrips = tripService.findAllTrips();
        } else if (role == Role.ROLE_DRIVER) {
            allTrips = tripService.findAllTrips().stream().filter(trip ->
            {
                assert driverByUsername != null;
                return Objects.equals(trip.getIdDriver().getId(), driverByUsername.getId());
            }).collect(Collectors.toList());
        }
        model.addAttribute("trips", allTrips);
        return "trips";
    }

    @GetMapping("/deleteTrip/{id}")
    public String deleteTrip(@PathVariable("id") Integer id) {
        tripService.deleteById(id);
        return "redirect:/trips/all";
    }


    @GetMapping("/editTrip/{id}")
    public String getEditTripPage(@PathVariable("id") Integer id, Model model) {
        Trip trip = tripService.findTripById(id);
        model.addAttribute("trip", trip);
        return "/editTrip";
    }

    @PostMapping("/editTrip")
    public String editTripById(Trip trip) {
        tripService.saveTrip(trip);
        return "redirect:/trips/all";
    }
}
