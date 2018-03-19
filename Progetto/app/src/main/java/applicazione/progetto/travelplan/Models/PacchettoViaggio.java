<<<<<<< HEAD:TravelPlan/src/it/appviaggi/model/PacchettoViaggio.java
package it.appviaggi.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PacchettoViaggio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPacchettoViaggio;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Luogo partenza_arrivo;
	
	@OneToMany(mappedBy="pacchettoViaggio", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Tappa> tappe;
	
	private int numeroPersone;

	@ManyToOne(cascade=CascadeType.ALL)
	private Utente utente;
	
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	private boolean completato;
	private boolean annullato;
	private boolean pagato;
	
	private String dataPartenza;
	
	public int getIdPacchettoViaggio() {
		return idPacchettoViaggio;
	}
	public void setIdPacchettoViaggio(int idPacchettoViaggio) {
		this.idPacchettoViaggio = idPacchettoViaggio;
	}
	public Luogo getPartenza_arrivo() {
		return partenza_arrivo;
	}
	public void setPartenza_arrivo(Luogo partenza_arrivo) {
		this.partenza_arrivo = partenza_arrivo;
	}
	public List<Tappa> getTappe() {
		return tappe;
	}
	public void setTappe(List<Tappa> tappe) {
		this.tappe = tappe;
	}
	public int getNumeroPersone() {
		return numeroPersone;
	}
	public void setNumeroPersone(int numeroPersone) {
		this.numeroPersone = numeroPersone;
	}
	public boolean isCompletato() {
		return completato;
	}
	public void setCompletato(boolean completato) {
		this.completato = completato;
	}
	public boolean isAnnullato() {
		return annullato;
	}
	public void setAnnullato(boolean annullato) {
		this.annullato = annullato;
	}
	public boolean isPagato() {
		return pagato;
	}
	public void setPagato(boolean pagato) {
		this.pagato = pagato;
	}
	public String getDataPartenza() {
		return dataPartenza;
	}
	public void setDataPartenza(String dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	
	
}
=======
package applicazione.progetto.travelplan.Models;

import java.util.List;


public class PacchettoViaggio {


	private int idPacchettoViaggio;
	
	private Luogo partenza;
	
	private List<Tappa> tappe;
	
	private int numeroPersone;
	
	private Tragitto viaggioDiRientro;
	
	private Luogo arrivo;

	private List<Utente> utente;
	
	private boolean completato;
	private boolean annullato;
	private boolean pagato;
	
	public int getIdPacchettoViaggio() {
		return idPacchettoViaggio;
	}
	public void setIdPacchettoViaggio(int idPacchettoViaggio) {
		this.idPacchettoViaggio = idPacchettoViaggio;
	}
	public Luogo getPartenza() {
		return partenza;
	}
	public void setPartenza(Luogo partenza) {
		this.partenza = partenza;
	}
	public List<Tappa> getTappe() {
		return tappe;
	}
	public void setTappe(List<Tappa> tappe) {
		this.tappe = tappe;
	}
	public Tragitto getViaggioDiRientro() {
		return viaggioDiRientro;
	}
	public void setViaggioDiRientro(Tragitto viaggioDiRientro) {
		this.viaggioDiRientro = viaggioDiRientro;
	}
	public Luogo getArrivo() {
		return arrivo;
	}
	public void setArrivo(Luogo arrivo) {
		this.arrivo = arrivo;
	}
	public boolean isCompletato() {
		return completato;
	}
	public void setCompletato(boolean confermato) {
		this.completato = confermato;
	}
	public boolean isAnnullato() {
		return annullato;
	}
	public void setAnnullato(boolean annullato) {
		this.annullato = annullato;
	}
	public boolean isPagato() {
		return pagato;
	}
	public void setPagato(boolean pagato) {
		this.pagato = pagato;
	}
	public int getNumeroPersone() {
		return numeroPersone;
	}
	public void setNumeroPersone(int numeroPersone) {
		this.numeroPersone = numeroPersone;
	}
	
	
}
>>>>>>> 86a5d816d9d9cb8aa940fd779664c4273bef9bfd:Progetto/app/src/main/java/applicazione/progetto/travelplan/Models/PacchettoViaggio.java
