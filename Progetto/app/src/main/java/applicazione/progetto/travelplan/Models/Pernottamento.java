package applicazione.progetto.travelplan.Models;

import java.util.Date;

	public class Pernottamento {
	

	private int idPernottamento;
	

	private Date dataArrivo;

	private Date dataPartenza;
	

	private Tappa tappa;
	

	private Struttura struttura;

	private TipoSoggiorno tipoSoggiorno;

	private TipoCamera tipoCamera;
	
	private int numeroPersone;
	
	private double prezzoTotale;

	public int getIdPernottamento() {
		return idPernottamento;
	}

	public void setIdPernottamento(int idPernottamento) {
		this.idPernottamento = idPernottamento;
	}

	public Date getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public Date getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	public Struttura getStruttura() {
		return struttura;
	}

	public void setStruttura(Struttura struttura) {
		this.struttura = struttura;
	}

	public TipoSoggiorno getTipoSoggiorno() {
		return tipoSoggiorno;
	}

	public void setTipoSoggiorno(TipoSoggiorno tipoSoggiorno) {
		this.tipoSoggiorno = tipoSoggiorno;
	}

	public TipoCamera getTipoCamera() {
		return tipoCamera;
	}

	public void setTipoCamera(TipoCamera tipoCamera) {
		this.tipoCamera = tipoCamera;
	}

	public int getNumeroPersone() {
		return numeroPersone;
	}

	public void setNumeroPersone(int numeroPersone) {
		this.numeroPersone = numeroPersone;
	}

	public double getPrezzoTotale() {
		return prezzoTotale;
	}

	public void setPrezzoTotale(double prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}
	
	

}
