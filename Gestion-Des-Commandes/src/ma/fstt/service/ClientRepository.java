package ma.fstt.service;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Client;

public interface ClientRepository {
	
	Client trouverById(int id)throws SQLException;
	void ajouterClient(Client client)throws SQLException;
	List<Client> listClients()throws SQLException;
	void updateClient(Client client)throws SQLException;
	void deleteClient(Client client)throws SQLException;
}
