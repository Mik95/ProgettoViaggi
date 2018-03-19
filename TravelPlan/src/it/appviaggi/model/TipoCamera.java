package it.appviaggi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoCamera {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipologiaCamera;
	private String nome;
	
	private int numeroLetti;
	
	private boolean wiFi;
	private boolean firgoBar;
	private boolean bagnoPrivato;
	private boolean tvSat;
	
	@OneToMany(mappedBy="tipoCamera", cascade=CascadeType.ALL)
	private List<DisponibilitaCamere> disponibilitaCamere;
	
	public int getIdTipologiaCamera() {
		return idTipologiaCamera;
	}
	public void setIdTipologiaCamera(int idTipologiaCamera) {
		this.idTipologiaCamera = idTipologiaCamera;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroLetti() {
		return numeroLetti;
	}
	public void setNumeroLetti(int numeroLetti) {
		this.numeroLetti = numeroLetti;
	}
	public boolean isWiFi() {
		return wiFi;
	}
	public void setWiFi(boolean wiFi) {
		this.wiFi = wiFi;
	}
	public boolean isFirgoBar() {
		return firgoBar;
	}
	public void setFirgoBar(boolean firgoBar) {
		this.firgoBar = firgoBar;
	}
	public boolean isBagnoPrivato() {
		return bagnoPrivato;
	}
	public void setBagnoPrivato(boolean bagnoPrivato) {
		this.bagnoPrivato = bagnoPrivato;
	}
	public boolean isTvSat() {
		return tvSat;
	}
	public void setTvSat(boolean tvSat) {
		this.tvSat = tvSat;
	}
	public List<DisponibilitaCamere> getDisponibilitaCamere() {
		return disponibilitaCamere;
	}
	public void setDisponibilitaCamere(List<DisponibilitaCamere> disponibilitaCamere) {
		this.disponibilitaCamere = disponibilitaCamere;
	}
	
	
}
