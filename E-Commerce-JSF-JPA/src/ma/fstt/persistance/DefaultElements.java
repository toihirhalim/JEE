package ma.fstt.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DefaultElements {
	private static final String PERSISTENCE_UNIT_NAME = "e_commerce";	
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();
	
	public static void createProduits() {
		if(!transactionObj.isActive()) {
			transactionObj.begin();
		}


		Cathegorie cat1 = new Cathegorie(0, "foods");
		Cathegorie cat2 = new Cathegorie(0, "Electronics");
		Cathegorie cat3 = new Cathegorie(0, "Clothes");

		Produit pr1 = new Produit(1, "Tea", 22);
		Produit pr2 = new Produit(1, "Burger", 50);
		Produit pr3 = new Produit(1, "Pizza", 30);
		Produit pr4 = new Produit(1, "Oil", 15);
		
		Produit pr5 = new Produit(1, "Laptop", 5000);
		Produit pr6 = new Produit(1, "cell phone", 2000);
		Produit pr7 = new Produit(1, "Keyboard", 100);
		

		Produit pr8 = new Produit(1, "Jacket", 500);
		Produit pr9 = new Produit(1, "T-short", 100);
		Produit pr10 = new Produit(1, "Shoes", 300);

		pr1.setCathegorie(cat1);
		pr2.setCathegorie(cat1);
		pr3.setCathegorie(cat1);
		pr4.setCathegorie(cat1);

		pr5.setCathegorie(cat2);
		pr6.setCathegorie(cat2);
		pr7.setCathegorie(cat2);
		
		pr8.setCathegorie(cat3);
		pr9.setCathegorie(cat3);
		pr10.setCathegorie(cat3);

		entityMgrObj.persist(pr1);
		entityMgrObj.persist(pr2);
		entityMgrObj.persist(pr3);
		entityMgrObj.persist(pr4);
		entityMgrObj.persist(pr5);
		entityMgrObj.persist(pr6);
		entityMgrObj.persist(pr7);
		entityMgrObj.persist(pr8);
		entityMgrObj.persist(pr9);
		entityMgrObj.persist(pr10);
		transactionObj.commit();
	}
}
