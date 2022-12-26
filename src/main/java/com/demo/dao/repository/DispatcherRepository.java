package com.demo.dao.repository;

import com.demo.dao.model.Dispatcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispatcherRepository extends CrudRepository<Dispatcher, Integer> {
    List<Dispatcher> findAll();

    Dispatcher findDispatcherByUsername(String username);

    void deleteById(Integer id);

    Dispatcher findDispatcherById(Integer id);
}
