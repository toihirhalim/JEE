package ma.fstt.service;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Produit;

public interface ProduitRepository {
	Produit trouverById(int id)throws SQLException;
	void ajouterProduit(Produit produit)throws SQLException;
	List<Produit> listProduits()throws SQLException;
	void updateProduit(Produit produit)throws SQLException;
	void deleteProduit(Produit produit)throws SQLException;
}
