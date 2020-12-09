package org.lsi.book.people.ticket.management.app.dao;

import org.lsi.book.people.ticket.management.app.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PeopleManagementDao extends CrudRepository<Person, Integer> {

}
