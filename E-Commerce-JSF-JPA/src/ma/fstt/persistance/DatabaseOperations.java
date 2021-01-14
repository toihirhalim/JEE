package ma.fstt.persistance;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class DatabaseOperations {
	private static final String PERSISTENCE_UNIT_NAME = "e_commerce";	
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();
	
	public static String creerClient(String nom , String adresse) {
		if(!transactionObj.isActive()) {
			transactionObj.begin();
		}

		Client client = new Client(0, nom , adresse);
		Panier panier = new Panier(0,0);
		client.setPanier(panier);
		
		entityMgrObj.persist(client);

		transactionObj.commit();
		return "listEtudiant.xhtml?faces-redirect=true";	
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Produit> getAllProduits() {
		Query queryObj = entityMgrObj.createQuery("SELECT e FROM Produit e");
		List<Produit> lList = queryObj.getResultList();
		if (lList != null && lList.size() > 0) {			
			return lList;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Cathegorie> getAllCathegories() {
		Query queryObj = entityMgrObj.createQuery("SELECT e FROM Cathegorie e");
		List<Cathegorie> lList = queryObj.getResultList();
		if (lList != null && lList.size() > 0) {			
			return lList;
		} else {
			return null;
		}
	}
	
}
