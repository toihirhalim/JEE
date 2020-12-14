package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientDao;
import com.example.demo.entities.Client;

@Service
public class ClientService {
	@Autowired
	private ClientDao clientDao;
	
	public Client createClient(Client client) {
		// TODO Auto-generated method stub
		return clientDao.save(client);
	}
	
}
