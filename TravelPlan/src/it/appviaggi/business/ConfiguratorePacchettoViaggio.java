package it.appviaggi.business;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;

import it.appviaggi.model.Luogo;
import it.appviaggi.model.MezzoDiTrasporto;
import it.appviaggi.model.PacchettoViaggio;
import it.appviaggi.model.Pernottamento;
import it.appviaggi.model.Struttura;
import it.appviaggi.model.Tappa;
import it.appviaggi.model.TipoCamera;
import it.appviaggi.model.TipoSoggiorno;
import it.appviaggi.model.TitoloDiViaggio;
import it.appviaggi.model.Tragitto;

public class ConfiguratorePacchettoViaggio {
	
	public PacchettoViaggio creaPacchettoViaggio(Date dataPartenza, Date dataArrivo, Luogo partenza,
			Luogo arrivo, int numeroPersone) {
		
		EntityManager em = JPAUtility.em();
		em.getTransaction().begin();
		PacchettoViaggio pv = new PacchettoViaggio();
		em.persist(pv);
		
		pv.setPartenza(partenza);
		pv.setArrivo(arrivo);
		
		pv.setTappe(new ArrayList<>());
		Tappa inizio = new Tappa();
		inizio.setPacchettoViaggio(pv);
		
		Tragitto tragitto = new Tragitto();
		tragitto.setDataPartenza(dataPartenza);
		inizio.setTragitto(tragitto);
		pv.getTappe().add(inizio);
		
		pv.setNumeroPersone(numeroPersone);
		
		Tragitto rientro = new Tragitto();
		rientro.setDataArrivo(dataArrivo);
		
		pv.setViaggioDiRientro(rientro);
		
		pv.setCompletato(false);
		pv.setAnnullato(false);
		pv.setPagato(false);
		
		em.getTransaction().commit();
		return pv;
	}
	
	public Pernottamento aggiungiPernottamentoATappa(Tappa tappa, Struttura struttura, Date dataArrivo, Date dataPartenza, int numeroPersone,
			TipoCamera tipoCamera, TipoSoggiorno tipoSoggiorno) {
		EntityManager em = JPAUtility.em();
		em.getTransaction().begin();
		
		Pernottamento p = new Pernottamento();
		p.setDataArrivo(dataArrivo);
		p.setDataPartenza(dataPartenza);
		p.setNumeroPersone(numeroPersone);
		p.setStruttura(struttura);
		p.setTipoCamera(tipoCamera);
		p.setTipoSoggiorno(tipoSoggiorno);
		
		tappa.setPernottamento(p);
		
		em.getTransaction().commit();
		return p;
	}
	
	public Tragitto aggiungiTragittoATappa(Tappa tappa, Date dataPartenza, Date dataArrivo, Luogo luogoPartenza, Luogo luogoArrivo,
			MezzoDiTrasporto mezzoDiTrasporto, String compagnia, String codiceBiglietto, double prezzo)  {
		EntityManager em = JPAUtility.em();
		em.getTransaction().begin();
		
		Tragitto t = new Tragitto();
		TitoloDiViaggio titoloDiViaggio = new TitoloDiViaggio();
		titoloDiViaggio.setCodiceTitolo(codiceBiglietto);
		titoloDiViaggio.setCompagnia(compagnia);
		titoloDiViaggio.setMezzoDiTrasporto(mezzoDiTrasporto);
		titoloDiViaggio.setPrezzo(prezzo);
		t.setTitoloDiViaggio(titoloDiViaggio);
		
		t.setDataArrivo(dataArrivo);
		t.setDataPartenza(dataPartenza);
		t.setLuogoArrivo(luogoArrivo);
		t.setLuogoPartenza(luogoPartenza);

		tappa.setTragitto(t);
		em.getTransaction().commit();
		return t;
	}

	public Tappa aggiungiNuovaTappa(Tappa tappaPrecedente) {
		Tappa t = new Tappa();
		t.setPacchettoViaggio(tappaPrecedente.getPacchettoViaggio());
		tappaPrecedente.getPacchettoViaggio().getTappe().add(t);
		return t;
	}
	

}
