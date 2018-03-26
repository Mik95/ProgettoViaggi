package applicazione.progetto.travelplan.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Luogo {


	@SerializedName("idLuogo")
	int id;
	@SerializedName("nome")
	String nome;

	public Luogo()
	{

	}

	public Luogo(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

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
	
	

}
