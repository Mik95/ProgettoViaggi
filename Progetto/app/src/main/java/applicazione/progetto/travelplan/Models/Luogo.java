package applicazione.progetto.travelplan.Models;

import java.util.List;

public class Luogo {
	

	private int idLuogo;
	
	private String nome;


	public Luogo()
		{

	}

	public Luogo(String nome)
	{
		this.nome=nome;
	}

	public int getIdLuogo() {
		return idLuogo;
	}

	public void setIdLuogo(int idLuogo) {
		this.idLuogo = idLuogo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
