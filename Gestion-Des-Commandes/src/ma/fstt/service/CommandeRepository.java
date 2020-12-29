package ma.fstt.service;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Commande;

public interface CommandeRepository {
	Commande trouverById(int id)throws SQLException;
	void ajouterCommande(Commande commande)throws SQLException;
	List<Commande> listCommande()throws SQLException;
	void updateCommande(Commande commande)throws SQLException;
	void deleteCommande(Commande commande)throws SQLException;
}
