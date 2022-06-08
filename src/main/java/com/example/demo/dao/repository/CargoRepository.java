package com.example.demo.dao.repository;

import com.example.demo.dao.model.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends CrudRepository <Cargo, Integer> {
    List<Cargo> findAll ();

    void deleteById(Integer id);
}
