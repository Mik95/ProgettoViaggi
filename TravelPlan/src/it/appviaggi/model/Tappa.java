package it.appviaggi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Tappa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTappa;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Tragitto tragitto;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Pernottamento pernottamento;
	
	@ManyToOne(cascade=CascadeType.ALL)
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
