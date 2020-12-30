package ma.fstt.service;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Commande;
import ma.fstt.entities.LigneCommande;
import ma.fstt.entities.Produit;

public interface LigneCommandeRepository {
	LigneCommande trouverById(int id)throws SQLException;
	void ajouterLigneCommande(LigneCommande ligneCommande)throws SQLException;
	List<LigneCommande> listLigneCommande()throws SQLException;
	List<LigneCommande> listLigneCommande(Commande commande)throws SQLException;
	void updateLigneCommande(LigneCommande ligneCommande)throws SQLException;
	void deleteLigneCommande(LigneCommande ligneCommande)throws SQLException;
	void deleteLigneCommande(Produit produit)throws SQLException;
	void deleteLigneCommande(Commande commande)throws SQLException;
}
