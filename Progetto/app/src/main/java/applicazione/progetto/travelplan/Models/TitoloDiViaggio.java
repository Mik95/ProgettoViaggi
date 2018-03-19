package applicazione.progetto.travelplan.Models;


public class TitoloDiViaggio {

	private int idTitoloDiViaggio;
	
	private MezzoDiTrasporto mezzoDiTrasporto;
	
	private Tragitto tragitto;
	
	private String compagnia;
	private String codiceTitolo;
	
	private double prezzo;

	public int getIdTitoloDiViaggio() {
		return idTitoloDiViaggio;
	}

	public void setIdTitoloDiViaggio(int idTitoloDiViaggio) {
		this.idTitoloDiViaggio = idTitoloDiViaggio;
	}

	public MezzoDiTrasporto getMezzoDiTrasporto() {
		return mezzoDiTrasporto;
	}

	public void setMezzoDiTrasporto(MezzoDiTrasporto mezzoDiTrasporto) {
		this.mezzoDiTrasporto = mezzoDiTrasporto;
	}

	public String getCompagnia() {
		return compagnia;
	}

	public void setCompagnia(String compagnia) {
		this.compagnia = compagnia;
	}

	public String getCodiceTitolo() {
		return codiceTitolo;
	}

	public void setCodiceTitolo(String codiceTitolo) {
		this.codiceTitolo = codiceTitolo;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	
}
