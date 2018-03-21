package it.appviaggi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utente {
	@Id
	private String email;
	private String nome;
	private String cognome;
	private String password;
	
	@OneToMany(mappedBy="utente", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<PacchettoViaggio> pacchettoViaggio;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PacchettoViaggio> getPacchettoViaggio() {
		return pacchettoViaggio;
	}

	public void setPacchettoViaggio(List<PacchettoViaggio> pacchettoViaggio) {
		this.pacchettoViaggio = pacchettoViaggio;
	}
	

}
