package it.appviaggi.business;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoViaggi");
		
	}

}
