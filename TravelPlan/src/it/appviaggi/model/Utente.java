package it.appviaggi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String cognome;
	private String email;
	private String username;
	private String password;
	
	@ManyToMany(mappedBy="utente", cascade=CascadeType.ALL)
	private List<PacchettoViaggio> pacchettoViaggio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
