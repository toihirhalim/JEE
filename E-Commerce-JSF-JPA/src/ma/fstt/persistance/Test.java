package ma.fstt.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
			EntityManagerFactory emf =
					Persistence.createEntityManagerFactory("e_commerce");
					EntityManager em = emf.createEntityManager();
			
			
			
			em.getTransaction().begin();
			Produit  pr = new Produit(1, "lsi2", 22);
			em.persist(pr);
			em.getTransaction().commit();
			
			
			
	}

}
