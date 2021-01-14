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
			
			/*Cathegorie cat = new Cathegorie(0, "foods");

			Produit pr1 = new Produit(1, "Tea", 22);
			Produit pr2 = new Produit(1, "Burger", 50);
			Produit pr3 = new Produit(1, "Pizza", 30);
			Produit pr4 = new Produit(1, "Oil", 15);

			pr1.setCathegorie(cat);
			pr2.setCathegorie(cat);
			pr3.setCathegorie(cat);
			pr4.setCathegorie(cat);

			em.getTransaction().begin();
			em.persist(pr1);
			em.persist(pr2);
			em.persist(pr3);
			em.persist(pr4);
			em.getTransaction().commit();*/
			
	
			
	}

}
