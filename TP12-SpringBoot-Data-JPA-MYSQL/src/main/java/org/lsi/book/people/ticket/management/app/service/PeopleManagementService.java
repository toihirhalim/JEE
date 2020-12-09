package org.lsi.book.people.ticket.management.app.service;

import java.util.List;
import org.lsi.book.people.ticket.management.app.dao.PeopleManagementDao;
import org.lsi.book.people.ticket.management.app.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleManagementService {
	@Autowired
	private PeopleManagementDao peopleManagementDao;
	public Person createPerson(Person person1) {
	// TODO Auto-generated method stub
	return peopleManagementDao.save(person1);
	}
	public Iterable<Person> createPersons(List<Person> personList) {
	// TODO Auto-generated method stub
	Iterable<Person> list = peopleManagementDao.saveAll(personList);
	return list;
	}
	public Iterable<Person> getPersonByIds(List<Integer> ids) {
		return peopleManagementDao.findAllById(ids);
		}
}
