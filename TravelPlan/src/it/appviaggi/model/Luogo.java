package it.appviaggi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Luogo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLuogo;
	
	private String nome;
	
	@OneToMany(mappedBy="luogo", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Struttura> strutture;
	
	@OneToMany(mappedBy="partenza_arrivo", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<PacchettoViaggio> pacchettiViaggio;
	
	@OneToMany(mappedBy="partenza", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<MezzoDiTrasporto> partenze;
	
	@OneToMany(mappedBy="arrivo", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<MezzoDiTrasporto> arrivi;

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

	public List<PacchettoViaggio> getPacchettiViaggio() {
		return pacchettiViaggio;
	}

	public void setPacchettiViaggio(List<PacchettoViaggio> pacchettiViaggio) {
		this.pacchettiViaggio = pacchettiViaggio;
	}

	public List<MezzoDiTrasporto> getPartenze() {
		return partenze;
	}

	public void setPartenze(List<MezzoDiTrasporto> partenze) {
		this.partenze = partenze;
	}

	public List<MezzoDiTrasporto> getArrivi() {
		return arrivi;
	}

	public void setArrivi(List<MezzoDiTrasporto> arrivi) {
		this.arrivi = arrivi;
	}

	

}
