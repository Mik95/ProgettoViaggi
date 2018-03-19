<<<<<<< HEAD:TravelPlan/src/it/appviaggi/model/Tappa.java
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
=======
package applicazione.progetto.travelplan.Models;



public class Tappa {
	
	private int idTappa;
	
	private Tragitto tragitto;
	
	private Pernottamento pernottamento;
	
	private PacchettoViaggio pacchettoViaggio;

	public int getIdTappa() {
		return idTappa;
	}

	public void setIdTappa(int idTappa) {
		this.idTappa = idTappa;
	}

	public Tragitto getTragitto() {
		return tragitto;
	}

	public void setTragitto(Tragitto tragitto) {
		this.tragitto = tragitto;
	}

	public Pernottamento getPernottamento() {
		return pernottamento;
	}

	public void setPernottamento(Pernottamento pernottamento) {
		this.pernottamento = pernottamento;
	}

	public PacchettoViaggio getPacchettoViaggio() {
		return pacchettoViaggio;
	}

	public void setPacchettoViaggio(PacchettoViaggio pacchettoViaggio) {
		this.pacchettoViaggio = pacchettoViaggio;
	}
	
	

}
>>>>>>> 86a5d816d9d9cb8aa940fd779664c4273bef9bfd:Progetto/app/src/main/java/applicazione/progetto/travelplan/Models/Tappa.java
