package ma.fstt.service;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.entities.Produit;

public interface ProduitRepository {
	Produit trouverById(int id)throws SQLException;
	void ajouterProduit(Client client)throws SQLException;
	List<Client> listProduits()throws SQLException;
	void updateProduit(Client client)throws SQLException;
	void deleteProduit(Client client)throws SQLException;
}
