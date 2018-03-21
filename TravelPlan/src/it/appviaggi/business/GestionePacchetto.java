package it.appviaggi.business;

import javax.persistence.EntityManager;

import it.appviaggi.model.Luogo;
import it.appviaggi.model.MezzoDiTrasporto;
import it.appviaggi.model.PacchettoViaggio;
import it.appviaggi.model.Utente;
import it.appviaggi.model.ViaggioDiRientro;
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
	
	public boolean inserisciViaggioRientro(int idLuogo, int idMezzo, int idPacchetto) {
		
		EntityManager em = JPAUtils.getInstance().getEm();
		Luogo l =em.find(Luogo.class, idLuogo);
		MezzoDiTrasporto m =em.find(MezzoDiTrasporto.class, idMezzo);
		PacchettoViaggio p =em.find(PacchettoViaggio.class, idPacchetto);
		ViaggioDiRientro r = new ViaggioDiRientro();
		
			r.setArrivo(l);
			r.setMezzo(m);
			r.setPacchettoViaggio(p);
			em.getTransaction().begin();
			em.persist(r);
			em.getTransaction().commit();
			
			p.setRientro(r);
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		
		return true;
	}
	
	public boolean eliminaPacchetto(int idPacchetto) {
		
		try {
			EntityManager em = JPAUtils.getInstance().getEm();
			PacchettoViaggio p =em.find(PacchettoViaggio.class, idPacchetto);
			if(p!=null) {
				em.getTransaction().begin();
				em.remove(p);
				em.getTransaction().commit();
				return true;
			}
		}catch (Exception ex) {
			System.out.println(ex);
		}
		return false;
		
	}		
}
