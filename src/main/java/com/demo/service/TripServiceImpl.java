package com.demo.service;

import com.demo.dao.model.Trip;
import com.demo.dao.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public List<Trip> findAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public void saveTrip(Trip trip) {
        tripRepository.save(trip);
    }

    @Override
    public void deleteById(Integer id) {
        tripRepository.deleteById(id);
    }

    @Override
    public Trip findTripById(Integer id) {
        return tripRepository.findTripById(id);
    }
}
