package org.lsi.book.ticket.app.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ticket_id")
	private Integer ticketId;
	@Column(name="passenger_name", nullable= false)
	private String passengerName;
	@Column(name="booking_date")
	private Date booking_date;
	@Column(name="source_station")
	private String sourceStation;
	@Column(name="dest_station")
	private String destStation;
	@Column(name="email")
	private String email;
	public Integer getTicketId() {
	return ticketId;
	}
	public void setTicketId(Integer ticketId) {
	this.ticketId = ticketId;
	}
	public String getPassengerName() {
	return passengerName;
	}
	public void setPassengerName(String passengerName) {
	this.passengerName = passengerName;
	}
	public Date getBooking_date() {
	return booking_date;
	}
	public void setBooking_date(Date booking_date) {
	this.booking_date = booking_date;
	}
	public String getSourceStation() {
	return sourceStation;
	}
	public void setSourceStation(String sourceStation) {
	this.sourceStation = sourceStation;
	}
	public String getDestStation() {
	return destStation;
	}
	public void setDestStation(String destStation) {
	this.destStation = destStation;
	}
	public String getEmail() {
	return email;
	}
	public void setEmail(String email) {
	this.email = email;
	}
}
