package applicazione.progetto.travelplan.Models;

import java.util.Date;
import java.util.List;

public class Tragitto {
	
	private int idTragitto;
	
	private Date dataArrivo;
	private Date dataPartenza;
	
	private Luogo luogoPartenza;
	private Luogo luogoArrivo;
	
	private Tappa tappa;
	
	private TitoloDiViaggio titoloDiViaggio;
	
	private List<PacchettoViaggio> pacchettiRientro;

	public Tragitto()
	{

	}

	public Tragitto( Date dataPartenza, Date dataArrivo,Luogo luogoPartenza, Luogo luogoArrivo)
	{
		this.dataPartenza =dataPartenza;
		this.dataArrivo = dataArrivo;
		this.luogoPartenza = luogoPartenza;
		this.luogoArrivo = luogoArrivo;
	}

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
