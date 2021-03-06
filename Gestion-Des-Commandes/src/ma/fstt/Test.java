package ma.fstt;

import java.sql.SQLException;

import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.CommandeDAO;
import ma.fstt.dao.LigneCommandeDAO;
import ma.fstt.dao.ProduitDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.entities.LigneCommande;
import ma.fstt.entities.Produit;

public class Test {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		ClientDAO clientDAO = new ClientDAO();
		ProduitDAO produitDAO = new ProduitDAO();
		CommandeDAO commandeDAO = new CommandeDAO();
		LigneCommandeDAO ligneCommandeDAO = new LigneCommandeDAO();
		
		
		//ligne de commande test
		
		/*	
	  	LigneCommande ligneCommande1 = new LigneCommande(0, 2, 2, 5);
		LigneCommande ligneCommande2 = new LigneCommande(0, 1, 2, 1);
		LigneCommande ligneCommande3 = new LigneCommande(0, 2, 1, 3);
		ligneCommandeDAO.ajouterLigneCommande(ligneCommande1);
		ligneCommandeDAO.ajouterLigneCommande(ligneCommande2);
		ligneCommandeDAO.ajouterLigneCommande(ligneCommande3);
		
		LigneCommande ligneCommande = ligneCommandeDAO.trouverById(7);
		
		System.out.println(ligneCommande);
		
		ligneCommande.setQtte(10);
		
		ligneCommandeDAO.updateLigneCommande(ligneCommande);
		
		ligneCommandeDAO.deleteLigneCommande(ligneCommande);
		
		for (LigneCommande lctmp : ligneCommandeDAO.listLigneCommande()) {
			
			System.out.println(lctmp.toString());
			
		}*/
		
		
		//commande test
				/*CommandeDAO commandeDAO = new CommandeDAO();

				Commande commande1 = new Commande(0, 1, null);
				Commande commande2 = new Commande(0, 2, null);
				Commande commande3 = new Commande(0, 1, null);
				commandeDAO.ajouterCommande(commande1);
				commandeDAO.ajouterCommande(commande2);
				commandeDAO.ajouterCommande(commande3);
				
				Commande commande = commandeDAO.trouverById(6);
				
				System.out.println(commande);
				
				commande.setIdClient(2);
				
				commandeDAO.updateCommande(commande);
				
				commandeDAO.deleteCommande(commande);
				
				for (Commande cmdtmp : commandeDAO.listCommande()) {
					
					System.out.println(cmdtmp.toString());
					
				}*/
		
		
		//produit test
		/*

		Produit produit = new Produit(0, "produit 3", 20);
		produitDAO.ajouterProduit(produit);
		
		Produit produit = produitDAO.trouverById(3);
		
		System.out.println(produit);
		
		produit.setPrix(10);
		produit.setLibele("unwanted produit");
		
		produitDAO.updateProduit(produit);
		
		produitDAO.deleteProduit(produit);
		
		for (Produit prdtmp : produitDAO.listProduits()) {
			
			System.out.println(prdtmp.toString());
			
		}*/
		
		
		
		//client test
		/*

		Client client = new Client(0, "client 3");
		clientDAO.ajouterClient(client);
		
		for (Client cltmp : clientDAO.listClients()) {
			
			System.out.println(cltmp.toString());
			
		}*/
		
		
	}
}
