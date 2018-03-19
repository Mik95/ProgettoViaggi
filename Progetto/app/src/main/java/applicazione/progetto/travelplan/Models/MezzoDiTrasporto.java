<<<<<<< HEAD:TravelPlan/src/it/appviaggi/model/MezzoDiTrasporto.java
package it.appviaggi.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class MezzoDiTrasporto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMezzoDiTrasporto;
	
	private String tipoMezzo;

	private String data;
	
	private String ora;
	
	private double prezzo;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Luogo partenza;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Luogo arrivo;
	
	@OneToMany(mappedBy="mezzo", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Tappa> tappa;
	
	public int getIdMezzoDiTrasporto() {
		return idMezzoDiTrasporto;
	}

	public void setIdMezzoDiTrasporto(int idMezzoDiTrasporto) {
		this.idMezzoDiTrasporto = idMezzoDiTrasporto;
	}

	public String getTipoMezzo() {
		return tipoMezzo;
	}

	public void setTipoMezzo(String tipoMezzo) {
		this.tipoMezzo = tipoMezzo;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public List<Tappa> getTappa() {
		return tappa;
	}

	public void setTappa(List<Tappa> tappa) {
		this.tappa = tappa;
	}

	public Luogo getPartenza() {
		return partenza;
	}

	public void setPartenza(Luogo partenza) {
		this.partenza = partenza;
	}

	public Luogo getArrivo() {
		return arrivo;
	}

	public void setArrivo(Luogo arrivo) {
		this.arrivo = arrivo;
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	

}
=======
package applicazione.progetto.travelplan.Models;

import java.util.List;

public class MezzoDiTrasporto {
	
	private int idMezzoDiTrasporto;
	
	private String nome;
	
	private List<TitoloDiViaggio> titoliDiViaggio;

	public int getIdMezzoDiTrasporto() {
		return idMezzoDiTrasporto;
	}

	public void setIdMezzoDiTrasporto(int idMezzoDiTrasporto) {
		this.idMezzoDiTrasporto = idMezzoDiTrasporto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
>>>>>>> 86a5d816d9d9cb8aa940fd779664c4273bef9bfd:Progetto/app/src/main/java/applicazione/progetto/travelplan/Models/MezzoDiTrasporto.java
