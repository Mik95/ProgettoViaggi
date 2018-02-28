package it.appviaggi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class TipoSoggiorno {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoSoggiorno;
	private String nome;
	
	@ManyToMany
	private List<Struttura> strutture;
	
	public int getIdTipoSoggiorno() {
		return idTipoSoggiorno;
	}
	public void setIdTipoSoggiorno(int idTipoSoggiorno) {
		this.idTipoSoggiorno = idTipoSoggiorno;
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
