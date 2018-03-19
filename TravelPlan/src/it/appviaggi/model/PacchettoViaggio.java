package it.appviaggi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PacchettoViaggio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPacchettoViaggio;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Luogo partenza;
	
	@OneToMany(mappedBy="pacchettoViaggio", cascade=CascadeType.ALL)
	private List<Tappa> tappe;
	
	private int numeroPersone;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Tragitto viaggioDiRientro;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Luogo arrivo;
	@ManyToMany(cascade=CascadeType.ALL)
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
