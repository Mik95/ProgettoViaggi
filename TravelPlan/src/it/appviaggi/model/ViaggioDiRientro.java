package it.appviaggi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ViaggioDiRientro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idViaggioDiRientro;

	@ManyToOne
	private Luogo arrivo;
	
	@ManyToOne
	private MezzoDiTrasporto mezzo;
	
	@OneToOne
	@JsonIgnore
	private PacchettoViaggio pacchettoViaggio;

	public int getIdViaggioDiRientro() {
		return idViaggioDiRientro;
	}

	public void setIdViaggioDiRientro(int idViaggioDiRientro) {
		this.idViaggioDiRientro = idViaggioDiRientro;
	}

	public Luogo getArrivo() {
		return arrivo;
	}

	public void setArrivo(Luogo arrivo) {
		this.arrivo = arrivo;
	}

	public MezzoDiTrasporto getMezzo() {
		return mezzo;
	}

	public void setMezzo(MezzoDiTrasporto mezzo) {
		this.mezzo = mezzo;
	}

	public PacchettoViaggio getPacchettoViaggio() {
		return pacchettoViaggio;
	}

	public void setPacchettoViaggio(PacchettoViaggio pacchettoViaggio) {
		this.pacchettoViaggio = pacchettoViaggio;
	}
	
	

}
