package it.appviaggi.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pernottamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPernottamento;
	
	@Temporal(TemporalType.DATE)
	private Date dataArrivo;
	@Temporal(TemporalType.DATE)
	private Date dataPartenza;
	
	@OneToOne(mappedBy="pernottamento", cascade=CascadeType.ALL)
	private Tappa tappa;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Struttura struttura;
	@ManyToOne(cascade=CascadeType.ALL)
	private TipoSoggiorno tipoSoggiorno;
	@ManyToOne(cascade=CascadeType.ALL)
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
