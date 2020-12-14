package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Client;

public interface ClientDao extends CrudRepository<Client, Long> {

}
