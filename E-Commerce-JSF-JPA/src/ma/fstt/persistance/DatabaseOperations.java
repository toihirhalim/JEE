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
	
	public static String creerProduit(String libele , int prix, String cathegorie) {
		if(!transactionObj.isActive()) {
			transactionObj.begin();
		}

		Produit produit = new Produit(0, libele , prix);
		
		Cathegorie cat = getCathegorie(cathegorie);
		
		if(cat == null) {
			cat = new Cathegorie(0, cathegorie);
		}
		
		produit.setCathegorie(cat);
		
		entityMgrObj.persist(produit);

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
	
	public static Client getClient(String nomClient) {
		Query query = entityMgrObj.createQuery("select client from Client client where client.nom = :nom") ;
		query.setParameter("nom", nomClient);
	
		List<Client> lList = query.getResultList() ;
		
		if (lList != null && lList.size() > 0) {			
			return lList.get(0);
		} else {
			return null;
		}
	
	}
	
	public static Cathegorie getCathegorie(String nomCathegorie) {
		Query query = entityMgrObj.createQuery("select cathegorie from Cathegorie cathegorie where cathegorie.nom = :nom") ;
		query.setParameter("nom", nomCathegorie);
	
		List<Cathegorie> lList = query.getResultList() ;
		
		if (lList != null && lList.size() > 0) {			
			return lList.get(0);
		} else {
			return null;
		}
	
	}
	
}
