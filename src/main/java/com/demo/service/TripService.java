package com.demo.service;

import com.demo.dao.model.Trip;

import java.util.List;

public interface TripService {
    List<Trip> findAllTrips();

    void saveTrip(Trip trip);

    void deleteById(Integer id);

    Trip findTripById(Integer id);
}
