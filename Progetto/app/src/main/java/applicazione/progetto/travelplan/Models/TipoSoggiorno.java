package applicazione.progetto.travelplan.Models;

import java.util.List;


public class TipoSoggiorno {

	private int idTipoSoggiorno;
	private String nome;
	
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
