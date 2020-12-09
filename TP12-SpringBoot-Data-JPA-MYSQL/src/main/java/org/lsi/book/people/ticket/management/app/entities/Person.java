package org.lsi.book.people.ticket.management.app.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person_table")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="person_id")
	private int id;
	@Column(name="first_name",length=60,nullable=false)
	private String firstName;
	@Column(name="last_name",length=60,nullable=false)
	private String lastName;
	@Column(name="email",unique=true)
	private String email;
	@Column(name="creation_date")
	private Date creationDate;
	public Person(String firstName, String lastName, String email, Date
	creationDate) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.creationDate = creationDate;
	}
	public Person() {}
	@Override
	public String toString() {
	return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", creationDate=" + creationDate + "]";
	}
	public int getId() {
	return id;
	}
	public String getFirstName() {
	return firstName;
	}
	public String getLastName() {
	return lastName;
	}
	public String getEmail() {
	return email;
	}
	public Date getCreationDate() {
	return creationDate;
	}
}
