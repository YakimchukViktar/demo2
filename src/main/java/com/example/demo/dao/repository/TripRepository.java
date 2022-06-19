package com.example.demo.dao.repository;

import com.example.demo.dao.model.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends CrudRepository <Trip, Integer> {
    List<Trip> findAll ();

    void deleteById(Integer id);
}
