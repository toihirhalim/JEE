package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Compte;

public interface CompteDao extends CrudRepository<Compte, String>{

}
