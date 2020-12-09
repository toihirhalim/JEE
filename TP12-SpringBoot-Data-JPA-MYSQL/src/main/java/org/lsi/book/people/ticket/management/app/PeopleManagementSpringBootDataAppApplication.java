package org.lsi.book.people.ticket.management.app;

import java.util.Date;
import java.util.*;
import org.lsi.book.people.ticket.management.app.entities.Person;
import org.lsi.book.people.ticket.management.app.service.PeopleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PeopleManagementSpringBootDataAppApplication implements
CommandLineRunner {
	@Autowired
	private PeopleManagementService peopleMangementService;
	public static void main(String[] args) {
	SpringApplication.run(PeopleManagementSpringBootDataAppApplication.class,
	args);
	}
	@Override
	public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	//createPerson();
	createPersons();
		//getPersonByIds();
	}
	private void createPersons() {
	// TODO Auto-generated method stub
	java.util.List<Person> personList = Arrays.asList(new Person("Amine",
	"Alami", "amine.alami@gmail.com", new Date()),new Person("Hanan", "Sarsri",
	"hanan.sarsri@gmail.com", new Date()));
	Iterable<Person> createPersons =
	peopleMangementService.createPersons(personList);
	for(Person person : createPersons){
	System.out.println(person);
	}
	}
	private void createPerson() {
	// TODO Auto-generated method stub
	Person person1 = new Person("Yasyn", "Elyusufi",
	"elyusufiyasyn@gmail.com", new Date());
	Person personDB = peopleMangementService.createPerson(person1);
	}
	private void getPersonByIds() {
		// TODO Auto-generated method stub
		List<Integer> ids = new ArrayList<>();
		ids.add(2);
		ids.add(3);
		ids.add(20);
		Iterable<Person> personList = peopleMangementService.getPersonByIds(ids);
		// Java 8
		personList.forEach(System.out::println);
		}
	
}
