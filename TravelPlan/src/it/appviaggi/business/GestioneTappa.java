package it.appviaggi.business;

import javax.persistence.EntityManager;


import it.appviaggi.model.PacchettoViaggio;
import it.appviaggi.model.MezzoDiTrasporto;
import it.appviaggi.model.Struttura;
import it.appviaggi.model.Tappa;
import it.appviaggi.util.JPAUtils;

public class GestioneTappa {
	
	public boolean creaTappa(int idMezzo, int idStruttura, int idPacchetto, String data) {
		
		EntityManager em = JPAUtils.getInstance().getEm();
		PacchettoViaggio p =em.find(PacchettoViaggio.class, idPacchetto);
		MezzoDiTrasporto m =em.find(MezzoDiTrasporto.class, idMezzo);
		Struttura s =em.find(Struttura.class, idStruttura);		
		Tappa t = new Tappa();
		
			if (p!=null) {
				t.setDataFineTappa(data);
				t.setMezzo(m);
				t.setStruttura(s);
				t.setPacchettoViaggio(p);
				
				em.getTransaction().begin();
				em.persist(t);
				em.getTransaction().commit();
				
				return true;
			}
	
	return false;
}
	
	
}