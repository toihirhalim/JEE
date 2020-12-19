package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Employe;

public interface EmployeDao extends CrudRepository<Employe, Long>{

}
