package it.appviaggi.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Singleton: garantisce l'esistenza di una sola istanza di questa classe nella JVM
public class JPAUtils {
	
	private static final String PERSISTENCE_UNIT_NAME = "ProgettoViaggi";

	private static JPAUtils instance;
	
	private EntityManagerFactory emf;
	
	private JPAUtils() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	public static JPAUtils getInstance() {
		if(instance == null)
			instance = new JPAUtils();
		return instance;
	}
	
	public EntityManager getEm() {
		return emf.createEntityManager();
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

}
