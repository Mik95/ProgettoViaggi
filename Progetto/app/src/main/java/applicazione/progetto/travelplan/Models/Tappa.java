package applicazione.progetto.travelplan.Models;



public class Tappa {
	
	private int idTappa;
	
	private Tragitto tragitto;
	
	private Pernottamento pernottamento;
	
	private PacchettoViaggio pacchettoViaggio;

	public int getIdTappa() {
		return idTappa;
	}

	public void setIdTappa(int idTappa) {
		this.idTappa = idTappa;
	}

	public Tragitto getTragitto() {
		return tragitto;
	}

	public void setTragitto(Tragitto tragitto) {
		this.tragitto = tragitto;
	}

	public Pernottamento getPernottamento() {
		return pernottamento;
	}

	public void setPernottamento(Pernottamento pernottamento) {
		this.pernottamento = pernottamento;
	}

	public PacchettoViaggio getPacchettoViaggio() {
		return pacchettoViaggio;
	}

	public void setPacchettoViaggio(PacchettoViaggio pacchettoViaggio) {
		this.pacchettoViaggio = pacchettoViaggio;
	}
	
	

}
