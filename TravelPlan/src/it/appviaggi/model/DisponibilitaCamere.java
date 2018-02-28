package it.appviaggi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DisponibilitaCamere {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDisponibilitaCamere;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private TipoCamera tipoCamera;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Struttura struttura;
	
	private int numeroCamere;
	private double prezzo;
	
	public int getIdDisponibilitaCamere() {
		return idDisponibilitaCamere;
	}
	public void setIdDisponibilitaCamere(int idDisponibilitaCamere) {
		this.idDisponibilitaCamere = idDisponibilitaCamere;
	}
	public TipoCamera getTipoCamera() {
		return tipoCamera;
	}
	public void setTipoCamera(TipoCamera tipoCamera) {
		this.tipoCamera = tipoCamera;
	}
	public int getNumeroCamere() {
		return numeroCamere;
	}
	public void setNumeroCamere(int numeroCamere) {
		this.numeroCamere = numeroCamere;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	

}
