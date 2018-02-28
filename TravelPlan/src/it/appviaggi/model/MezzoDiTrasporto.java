package it.appviaggi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MezzoDiTrasporto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMezzoDiTrasporto;
	
	private String nome;
	
	@OneToMany(mappedBy="mezzoDiTrasporto", cascade= CascadeType.ALL)
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
