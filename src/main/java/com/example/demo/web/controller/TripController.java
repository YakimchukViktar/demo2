package com.example.demo.web.controller;

import com.example.demo.dao.model.Trip;
import com.example.demo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TripController {
    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping ("/trips/all")
    public String getAllTrips(Model model){
        List<Trip> allTrips = tripService.findAllTrips();
        model.addAttribute("trips",  allTrips);
        return "trips";
    }
}
