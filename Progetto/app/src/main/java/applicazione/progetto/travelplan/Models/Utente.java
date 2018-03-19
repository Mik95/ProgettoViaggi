package applicazione.progetto.travelplan.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Utente {


	@SerializedName("nome")
	private String nome;
	@SerializedName("cognome")
	private String cognome;
	@SerializedName("email")
	private String email;
	@SerializedName("password")
	private String password;
	
	public Utente (String email,String password)
	{
		this.email = email;
		this.password= password;
	}

	public Utente(String nome, String cognome, String email, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
