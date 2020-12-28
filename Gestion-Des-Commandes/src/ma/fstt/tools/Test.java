package ma.fstt.tools;

import java.sql.SQLException;

import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.ProduitDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Produit;

public class Test {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//produit test
		/*ProduitDAO produitDAO = new ProduitDAO();

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
		/*ClientDAO clientDAO = new ClientDAO();

		Client client = new Client(0, "client 3");
		clientDAO.ajouterClient(client);
		
		for (Client cltmp : clientDAO.listClients()) {
			
			System.out.println(cltmp.toString());
			
		}*/
		
	}
}
