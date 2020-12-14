package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
