package it.appviaggi.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtility {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoViaggi");
	
	public static EntityManager em() {
		return emf.createEntityManager();
	}
}
