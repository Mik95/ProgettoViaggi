package it.appviaggi.business.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import org.junit.Test;

import it.appviaggi.business.ConfiguratorePacchettoViaggio;
import it.appviaggi.business.JPAUtility;
import it.appviaggi.model.Luogo;
import it.appviaggi.model.MezzoDiTrasporto;
import it.appviaggi.model.PacchettoViaggio;
import it.appviaggi.model.Struttura;
import it.appviaggi.model.Tappa;
import it.appviaggi.model.TipoCamera;
import it.appviaggi.model.TipoSoggiorno;
import it.appviaggi.model.TitoloDiViaggio;
import it.appviaggi.model.Utente;

public class ConfiguratorePacchettoViaggioTest {
	
	@Test
	public void testEntityManager() {
		JPAUtility.em();
	}

	@Test
	public void testCreaPacchettoViaggio() {
		EntityManager em = JPAUtility.em();
		em.getTransaction().begin();
		ConfiguratorePacchettoViaggio cpv = new ConfiguratorePacchettoViaggio();
		
		Calendar domani = new GregorianCalendar();
		domani.set(Calendar.DATE, 18);
		
		Calendar metaGita = new GregorianCalendar();
		metaGita.set(Calendar.DATE, 23);
		
		Calendar fineMese = new GregorianCalendar();
		fineMese.set(Calendar.DATE, 31);
		
		Luogo partenza = new Luogo();
		partenza.setNome("Milano Maciachini");
		em.persist(partenza);
		
		Luogo arrivo = partenza;
		
		PacchettoViaggio pv = cpv.creaPacchettoViaggio(domani.getTime(), fineMese.getTime(), partenza, arrivo, 4);
		
		//Utente che parte
		Utente pino = new Utente();
		pino.setNome("Pino");
		pino.setCognome("Daniele");
		pino.setUsername("pinoDan");
		pino.setPassword("pinoDaniele");
		pino.setEmail("pino.daniele@gmail.com");
		em.persist(pino);
			
		// scelta della struttura
		Tappa primaTappa = pv.getTappe().get(0);
		
		Struttura ciPiaceARoma = new Struttura();
		ciPiaceARoma.setNome("Hotel Hilton a Roma");
		em.persist(ciPiaceARoma);
		
		TipoCamera doppia = new TipoCamera();
		doppia.setNome("Camera doppia");
		em.persist(doppia);
		TipoSoggiorno lussoAllInclusive = new TipoSoggiorno();
		lussoAllInclusive.setNome("Lusso All-Inclusive");
		em.persist(lussoAllInclusive);
		
		Luogo luogoRoma = new Luogo();
		luogoRoma.setNome("Roma urbe");
		em.persist(luogoRoma);
		// prenotazione del biglietto di viaggio
		MezzoDiTrasporto aereo = new MezzoDiTrasporto();
		aereo.setNome("Aereo");
		em.persist(aereo);
		
		cpv.aggiungiPernottamentoATappa(primaTappa, ciPiaceARoma, domani.getTime(), metaGita.getTime(), pv.getNumeroPersone(), doppia, lussoAllInclusive);
		cpv.aggiungiTragittoATappa(primaTappa, domani.getTime(), domani.getTime(), partenza, luogoRoma, aereo, "Ryanair", "AX-234567", 80);
		
		
		// aggiunta della tappa
		Tappa napoli = cpv.aggiungiNuovaTappa(primaTappa);
		em.persist(napoli);
		
		// scelta della struttura
		Struttura ciPiaceANapoli = new Struttura();
		ciPiaceANapoli.setNome("BnB Amici a Napoli");
		em.persist(ciPiaceANapoli);
		TipoSoggiorno bnb = new TipoSoggiorno();
		bnb.setNome("BnB");
		em.persist(bnb);
		Luogo luogoNapoli = new Luogo();
		luogoNapoli.setNome("Napoli porto");
		em.persist(luogoNapoli);
		
		// scelta del biglietto di trasporto
		MezzoDiTrasporto treno = new MezzoDiTrasporto();
		treno.setNome("Treno");
		em.persist(treno);
		
		cpv.aggiungiPernottamentoATappa(napoli, ciPiaceANapoli, metaGita.getTime(), fineMese.getTime(), pv.getNumeroPersone(), doppia, bnb);
		cpv.aggiungiTragittoATappa(napoli, metaGita.getTime(), metaGita.getTime(), luogoRoma, luogoNapoli, treno, "Frecciarossa", "KK-23744377", 54);
		
		// scelta del biglietto per il rientro
		pv.getViaggioDiRientro().setDataPartenza(fineMese.getTime());
		pv.getViaggioDiRientro().setDataArrivo(fineMese.getTime());
		pv.getViaggioDiRientro().setLuogoPartenza(luogoNapoli);
		pv.getViaggioDiRientro().setLuogoArrivo(arrivo);
		
		TitoloDiViaggio titoloDiViaggio = new TitoloDiViaggio();
		em.persist(titoloDiViaggio);
		titoloDiViaggio.setCodiceTitolo("SS-7656757");
		titoloDiViaggio.setCompagnia("Ryanair");
		titoloDiViaggio.setMezzoDiTrasporto(aereo);
		titoloDiViaggio.setPrezzo(78);
		pv.getViaggioDiRientro().setTitoloDiViaggio(titoloDiViaggio);
		em.getTransaction().commit();
	}

}
