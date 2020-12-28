package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.Client;

public interface ClientRepository {
	
	Client trouverById(String id);
	void ajouterClient(Client client);
	List<Client> listClient();
	void updateClient(Client client);
	void deleteClient(Client client);
}
