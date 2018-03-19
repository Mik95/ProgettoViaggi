package it.appviaggi.business;

import javax.persistence.EntityManager;

import it.appviaggi.model.Utente;
import it.appviaggi.util.JPAUtils;

public class GestioneAccount {

	public EsitoOperazione login(String username, String password) {
		EsitoOperazione _return = new EsitoOperazione();
		try {
			EntityManager em = JPAUtils.getInstance().getEm();
			Utente u = em.find(Utente.class, username);
			boolean ok = u != null && u.getPassword().equals(password);
			_return.setSuccess(ok);
			_return.setMessaggio(!ok ? "Accesso fallito" : "Accesso effettuato");
			if (ok)
				_return.setOggettoRisultante(u);
			else
				_return.setOggettoRisultante(null);
		} catch (Exception ex) {
			_return.setSuccess(false);
			_return.setMessaggio("Qualcosa è andato male => " + ex.getMessage());
			_return.setOggettoRisultante(ex.getMessage());
		}
		return _return;
	}

	public EsitoOperazione registraUtente(String email, String password, String nome, String cognome) {
		EsitoOperazione _return = new EsitoOperazione();
		Utente u = new Utente();
		u.setEmail(email);
		u.setPassword(password);
		u.setNome(nome);
		u.setCognome(cognome);
		_return = registraUtente(u);
		return _return;
	}
	
	public EsitoOperazione registraUtente(Utente nuovoUtente) {
		EsitoOperazione _return = new EsitoOperazione();
		try {
			EntityManager em = JPAUtils.getInstance().getEm();
			Utente u = em.find(Utente.class, nuovoUtente.getEmail());
			if(u != null) {
				_return.setSuccess(false);
				_return.setMessaggio("L'utente esiste già");
				_return.setOggettoRisultante(u);
			} else {				
				em.getTransaction().begin();
				em.persist(nuovoUtente);
				em.getTransaction().commit();
				
				_return.setSuccess(true);
				_return.setMessaggio("Utente creato con successo");
				_return.setOggettoRisultante(nuovoUtente);
			}
		} catch (Exception ex) {
			_return.setSuccess(false);
			_return.setMessaggio("Qualcosa è andato male => " + ex.getMessage());
			_return.setOggettoRisultante(ex);
		}
		return _return;
	}	

	public EsitoOperazione cambiaPwUtente(String email, String password) {
		EsitoOperazione _return = new EsitoOperazione();
		try {
			EntityManager em = JPAUtils.getInstance().getEm();
			Utente u = em.find(Utente.class, email);
			if (u != null) {
				u.setPassword(password);
				em.getTransaction().begin();
				em.persist(u);
				em.getTransaction().commit();
				_return.setSuccess(true);
				_return.setMessaggio("Password Cambiata");
				_return.setOggettoRisultante(u);
			} else {
				_return.setSuccess(false);
				_return.setMessaggio("L'utente non esiste");
				_return.setOggettoRisultante(null);
			}
		} catch (Exception ex) {
			_return.setSuccess(false);
			_return.setMessaggio("Qualcosa è andato male => " + ex.getMessage());
			_return.setOggettoRisultante(ex);
		}
		return _return;
	}
}