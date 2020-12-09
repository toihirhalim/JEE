package org.lsi.book.ticket.app.service;

import org.lsi.book.ticket.app.dao.TicketBookingDao;
import org.lsi.book.ticket.app.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingService {
	@Autowired
	private TicketBookingDao ticketBookingDao;
	public Ticket createTicket(Ticket ticket) {
	// TODO Auto-generated method stub
	return ticketBookingDao.save(ticket);
	}
	public Ticket getTicketById(Integer ticketId) {
	// TODO Auto-generated method stub
		return ticketBookingDao.findById(ticketId).orElse(null);
	}
	public Iterable<Ticket> getAllBookedTickets() {
	// TODO Auto-generated method stub
	return ticketBookingDao.findAll();
	}
	public void deleteTicket(Integer ticketId) {
	// TODO Auto-generated method stub
	ticketBookingDao.deleteById(ticketId);
	}
	public Ticket updateTicket(Integer ticketId, String newEmail) {
	// TODO Auto-generated method stub
	Ticket ticketFromDb =
	ticketBookingDao.findById(ticketId).orElse(null);
	ticketFromDb.setEmail(newEmail);
	Ticket updatedTicket = ticketBookingDao.save(ticketFromDb);
	return updatedTicket;
	}
}
