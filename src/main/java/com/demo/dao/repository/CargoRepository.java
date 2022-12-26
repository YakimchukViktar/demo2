package com.demo.dao.repository;

import com.demo.dao.model.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {
    List<Cargo> findAll();

}
