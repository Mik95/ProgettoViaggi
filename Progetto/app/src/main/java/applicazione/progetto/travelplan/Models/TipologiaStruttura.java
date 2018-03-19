package applicazione.progetto.travelplan.Models;

import java.util.List;


public class TipologiaStruttura {
	
	private int idTipologiaStruttura;
	private String nome;
	
	private List<Struttura> strutture;
	
	public int getIdTipologiaStruttura() {
		return idTipologiaStruttura;
	}
	public void setIdTipologiaStruttura(int idTipologiaStruttura) {
		this.idTipologiaStruttura = idTipologiaStruttura;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Struttura> getStrutture() {
		return strutture;
	}
	public void setStrutture(List<Struttura> strutture) {
		this.strutture = strutture;
	}
	
	

}
