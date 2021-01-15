package ma.fstt.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
			EntityManagerFactory emf =
					Persistence.createEntityManagerFactory("e_commerce");
			EntityManager em = emf.createEntityManager();
			
					
			//DefaultElements.createProduits();
			//DatabaseOperations.creerClient("Peter", "near the clouds");
			
			/*for(Produit produit : DatabaseOperations.getAllProduits()) {
				System.out.println(produit);
				System.out.println(produit.getCathegorie());
			}*/
			
			/*for(Cathegorie cathegorie : DatabaseOperations.getAllCathegories()) {
				System.out.println(cathegorie);
			}*/
			
			/*Client client = DatabaseOperations.getClient("Peter");
			System.out.println(client +"" +  client.getPanier());*/
			
			//System.out.println(DatabaseOperations.getCathegorie("foods"));
			
			//System.out.println(DatabaseOperations.creerProduit("Rice", 14, "foods"));
			
	}

}
