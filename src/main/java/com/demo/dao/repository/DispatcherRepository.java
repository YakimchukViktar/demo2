package com.demo.dao.repository;

import com.demo.dao.model.Dispatcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DispatcherRepository extends CrudRepository<Dispatcher, Integer> {

    Dispatcher findDispatcherByUsername(String username);

    Dispatcher findDispatcherById(Integer id);
}
