package applicazione.progetto.travelplan.Models;


public class DisponibilitaCamere {
	

	private int idDisponibilitaCamere;
	
	private TipoCamera tipoCamera;
	
	private Struttura struttura;
	
	private int numeroCamere;
	private double prezzo;
	
	public int getIdDisponibilitaCamere() {
		return idDisponibilitaCamere;
	}

	public void setIdDisponibilitaCamere(int idDisponibilitaCamere) {
		this.idDisponibilitaCamere = idDisponibilitaCamere;
	}
	public TipoCamera getTipoCamera() {
		return tipoCamera;
	}
	public void setTipoCamera(TipoCamera tipoCamera) {
		this.tipoCamera = tipoCamera;
	}
	public int getNumeroCamere() {
		return numeroCamere;
	}
	public void setNumeroCamere(int numeroCamere) {
		this.numeroCamere = numeroCamere;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	

}
