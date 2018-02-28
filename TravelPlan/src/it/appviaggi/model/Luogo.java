package it.appviaggi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Luogo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLuogo;
	
	private String nome;
	
	@OneToMany(mappedBy="luogo", cascade=CascadeType.ALL)
	private List<Struttura> strutture;
	
	@OneToMany(mappedBy="partenza", cascade=CascadeType.ALL)
	private List<PacchettoViaggio> pacchettiPartenze;
	
	@OneToMany(mappedBy="arrivo", cascade=CascadeType.ALL)
	private List<PacchettoViaggio> pacchettiArrivo;
	
	@OneToMany(mappedBy="luogoPartenza", cascade=CascadeType.ALL)
	private List<Tragitto> tragittiPartenze;
	
	@OneToMany(mappedBy="luogoArrivo", cascade=CascadeType.ALL)
	private List<Tragitto> tragittiArrivo;

	public int getIdLuogo() {
		return idLuogo;
	}

	public void setIdLuogo(int idLuogo) {
		this.idLuogo = idLuogo;
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

	public List<PacchettoViaggio> getPacchettiPartenze() {
		return pacchettiPartenze;
	}

	public void setPacchettiPartenze(List<PacchettoViaggio> pacchettiPartenze) {
		this.pacchettiPartenze = pacchettiPartenze;
	}

	public List<PacchettoViaggio> getPacchettiArrivo() {
		return pacchettiArrivo;
	}

	public void setPacchettiArrivo(List<PacchettoViaggio> pacchettiArrivo) {
		this.pacchettiArrivo = pacchettiArrivo;
	}
	
	

}
