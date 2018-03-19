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
