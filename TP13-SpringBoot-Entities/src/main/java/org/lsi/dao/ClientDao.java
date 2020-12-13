package org.lsi.dao;

import org.lsi.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientDao extends CrudRepository<Client, Integer>{

}
