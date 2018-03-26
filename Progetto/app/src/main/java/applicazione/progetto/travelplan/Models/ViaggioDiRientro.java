package applicazione.progetto.travelplan.Models;


public class ViaggioDiRientro {

	private int idViaggioDiRientro;

	private Luogo arrivo;

	private MezzoDiTrasporto mezzo;

	private PacchettoViaggio pacchettoViaggio;

	public int getIdViaggioDiRientro() {
		return idViaggioDiRientro;
	}

	public void setIdViaggioDiRientro(int idViaggioDiRientro) {
		this.idViaggioDiRientro = idViaggioDiRientro;
	}

	public Luogo getArrivo() {
		return arrivo;
	}

	public void setArrivo(Luogo arrivo) {
		this.arrivo = arrivo;
	}

	public MezzoDiTrasporto getMezzo() {
		return mezzo;
	}

	public void setMezzo(MezzoDiTrasporto mezzo) {
		this.mezzo = mezzo;
	}

	public PacchettoViaggio getPacchettoViaggio() {
		return pacchettoViaggio;
	}

	public void setPacchettoViaggio(PacchettoViaggio pacchettoViaggio) {
		this.pacchettoViaggio = pacchettoViaggio;
	}
	
	

}
