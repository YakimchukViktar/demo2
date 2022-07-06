package com.example.demo.dao.repository;

import com.example.demo.dao.model.Dispatcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DispatcherRepository extends CrudRepository<Dispatcher, Integer> {

    Dispatcher findDispatcherByUsername(String username);

    void deleteById(Integer id);

    Dispatcher findDispatcherById(Integer id);
}
