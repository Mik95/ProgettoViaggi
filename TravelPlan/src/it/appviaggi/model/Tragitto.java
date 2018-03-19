package it.appviaggi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tragitto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTragitto;
	
	@Temporal(TemporalType.DATE)
	private Date dataArrivo;
	@Temporal(TemporalType.DATE)
	private Date dataPartenza;
	
	@ManyToOne(cascade= CascadeType.ALL)
	private Luogo luogoPartenza;
	@ManyToOne(cascade= CascadeType.ALL)
	private Luogo luogoArrivo;
	
	@OneToOne(mappedBy="tragitto", cascade=CascadeType.ALL)
	private Tappa tappa;
	
	@OneToOne(cascade= CascadeType.ALL)
	private TitoloDiViaggio titoloDiViaggio;
	
	@OneToMany(mappedBy="viaggioDiRientro", cascade=CascadeType.ALL)
	private List<PacchettoViaggio> pacchettiRientro;

	public int getIdTragitto() {
		return idTragitto;
	}

	public void setIdTragitto(int idTragitto) {
		this.idTragitto = idTragitto;
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

	public Luogo getLuogoPartenza() {
		return luogoPartenza;
	}

	public void setLuogoPartenza(Luogo luogoPartenza) {
		this.luogoPartenza = luogoPartenza;
	}

	public Luogo getLuogoArrivo() {
		return luogoArrivo;
	}

	public void setLuogoArrivo(Luogo luogoArrivo) {
		this.luogoArrivo = luogoArrivo;
	}

	public TitoloDiViaggio getTitoloDiViaggio() {
		return titoloDiViaggio;
	}

	public void setTitoloDiViaggio(TitoloDiViaggio titoloDiViaggio) {
		this.titoloDiViaggio = titoloDiViaggio;
	}

	public List<PacchettoViaggio> getPacchettiRientro() {
		return pacchettiRientro;
	}

	public void setPacchettiRientro(List<PacchettoViaggio> pacchettiRientro) {
		this.pacchettiRientro = pacchettiRientro;
	}
	
	

}
