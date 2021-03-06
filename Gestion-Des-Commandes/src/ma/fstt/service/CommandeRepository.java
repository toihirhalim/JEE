package ma.fstt.service;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;

public interface CommandeRepository {
	Commande trouverById(int id)throws SQLException;
	Commande lastCommande()throws SQLException;
	void ajouterCommande(Commande commande)throws SQLException;
	List<Commande> listCommande()throws SQLException;
	List<Commande> listCommande(Client client)throws SQLException;
	void updateCommande(Commande commande)throws SQLException;
	void deleteCommande(Commande commande)throws SQLException;
}
