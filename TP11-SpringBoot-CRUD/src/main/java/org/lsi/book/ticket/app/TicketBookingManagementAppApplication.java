package org.lsi.book.ticket.app;

import java.util.Date;
import org.lsi.book.ticket.app.entities.Ticket;
import org.lsi.book.ticket.app.service.TicketBookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TicketBookingManagementAppApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
		SpringApplication.run(TicketBookingManagementAppApplication.class, args);
		TicketBookingService ticketBookingService =
		applicationContext.getBean("ticketBookingService",TicketBookingService.class);
		Ticket ticket = new Ticket();
		ticket.setBooking_date(new Date());
		ticket.setDestStation("Tanger");
		ticket.setSourceStation("Rabat");
		ticket.setPassengerName("Yasyn");
		ticket.setEmail("elyusufiyasyn@gmail.com");
		
		ticketBookingService.createTicket(ticket);
	}
}
