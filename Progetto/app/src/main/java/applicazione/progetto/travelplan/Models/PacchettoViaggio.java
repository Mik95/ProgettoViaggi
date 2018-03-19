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
