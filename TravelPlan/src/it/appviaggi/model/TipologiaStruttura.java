package it.appviaggi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipologiaStruttura {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipologiaStruttura;
	private String nome;
	
	@OneToMany(mappedBy="tipologiaStruttura", cascade=CascadeType.ALL)
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
