package com.example.demo.dao.repository;

import com.example.demo.dao.model.Dispatcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispatcherRepository extends CrudRepository<Dispatcher,Integer> {
   List<Dispatcher> findAll();
   Dispatcher findDispatcherByUsername (String username);
}
