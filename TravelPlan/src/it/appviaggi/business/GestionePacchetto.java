package it.appviaggi.business;

import javax.persistence.EntityManager;

import it.appviaggi.model.Luogo;
import it.appviaggi.model.PacchettoViaggio;
import it.appviaggi.model.Utente;
import it.appviaggi.util.JPAUtils;

public class GestionePacchetto {
	
	public int creaPacchetto(int nPersone, int idLuogo, String partenza, String email) {
		
		EntityManager em = JPAUtils.getInstance().getEm();
		Utente u =em.find(Utente.class, email);
		Luogo l =em.find(Luogo.class, idLuogo);
		PacchettoViaggio p = new PacchettoViaggio();
		
				p.setNumeroPersone(nPersone);
				p.setPartenza_arrivo(l);
				p.setDataPartenza(partenza);
				p.setAnnullato(false);
				p.setCompletato(false);
				p.setPagato(false);
				p.setUtente(u);
				em.getTransaction().begin();
				em.persist(p);
				em.getTransaction().commit();
				
				return p.getIdPacchettoViaggio();
				
	}

}
