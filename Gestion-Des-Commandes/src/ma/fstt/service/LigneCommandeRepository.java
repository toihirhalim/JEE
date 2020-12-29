package ma.fstt.service;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.LigneCommande;

public interface LigneCommandeRepository {
	LigneCommande trouverById(int id)throws SQLException;
	void ajouterLigneCommande(LigneCommande ligneCommande)throws SQLException;
	List<LigneCommande> listLigneCommande()throws SQLException;
	void updateLigneCommande(LigneCommande ligneCommande)throws SQLException;
	void deleteLigneCommande(LigneCommande ligneCommande)throws SQLException;
}
