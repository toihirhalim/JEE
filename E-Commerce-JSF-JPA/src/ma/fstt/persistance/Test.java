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
			
	
			
	}

}
