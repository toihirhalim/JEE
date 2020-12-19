package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Client;
import com.example.demo.service.ClientService;

@RestController
@RequestMapping(value="/api/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping(value="/create")
	public Client createClient(@RequestBody Client client){
		return clientService.createClient(client);
	}
	@GetMapping(value="/client/{clientId}")
	public Client getClientById(@PathVariable("clientId")Long clientId){
		return clientService.getClientById(clientId);
	}
	@GetMapping(value="/client/allclient")
	public Iterable<Client> getAllBookedClients(){
		return clientService.getAllBookedClients();
	}
	@DeleteMapping(value="/client/{clientId}")
	public void deleteTicket(@PathVariable("clientId")Long clientId){
		clientService.deleteClient(clientId);
	}
}
