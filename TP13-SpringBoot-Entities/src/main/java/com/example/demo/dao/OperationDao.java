package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Operation;

public interface OperationDao extends CrudRepository<Operation, Long>{

}
