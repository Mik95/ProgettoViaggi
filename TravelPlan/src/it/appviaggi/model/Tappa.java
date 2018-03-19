package it.appviaggi.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tappa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTappa;

	@ManyToOne(cascade=CascadeType.ALL)
	private Struttura struttura;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private MezzoDiTrasporto mezzo;
	
	private String dataFineTappa;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private PacchettoViaggio pacchettoViaggio;


	public int getIdTappa() {
		return idTappa;
	}

	public void setIdTappa(int idTappa) {
		this.idTappa = idTappa;
	}

	public PacchettoViaggio getPacchettoViaggio() {
		return pacchettoViaggio;
	}

	public void setPacchettoViaggio(PacchettoViaggio pacchettoViaggio) {
		this.pacchettoViaggio = pacchettoViaggio;
	}

	public Struttura getStruttura() {
		return struttura;
	}

	public void setStruttura(Struttura struttura) {
		this.struttura = struttura;
	}

	public MezzoDiTrasporto getMezzo() {
		return mezzo;
	}

	public void setMezzo(MezzoDiTrasporto mezzo) {
		this.mezzo = mezzo;
	}

	public String getDataFineTappa() {
		return dataFineTappa;
	}

	public void setDataFineTappa(String dataFineTappa) {
		this.dataFineTappa = dataFineTappa;
	}
	
	

}
