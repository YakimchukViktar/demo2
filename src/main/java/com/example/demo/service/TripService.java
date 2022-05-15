package com.example.demo.service;

import com.example.demo.dao.model.Trip;

import java.util.List;

public interface TripService {
    List<Trip> findAllTrips ();
}
