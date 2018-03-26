package applicazione.progetto.travelplan.Models;


import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PacchettoViaggio {

	@SerializedName("id")
	private int idPacchettoViaggio;
	@SerializedName("partenza")
	private Luogo partenza_arrivo;
	@SerializedName("tappe")
	private List<Tappa> tappe;
	@SerializedName("numeroPersone")
	private int numeroPersone;
	@SerializedName("utente")
	private Utente utente;

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	@SerializedName("tappa")
	private boolean completato;
	@SerializedName("tappa")
	private boolean annullato;
	@SerializedName("tappa")
	private boolean pagato;
	@SerializedName("tappa")
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
