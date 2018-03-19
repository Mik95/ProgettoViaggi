package it.appviaggi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Struttura {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStruttura;
	
	private String nome;
	private String numeroTelefono;
	private String email;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Luogo luogo;
	private double latitudine;
	private double longitudine;
	
	private boolean piscina;
	private boolean parcheggio;
	private boolean animaliAmmessi;
	private boolean salaGiochi;
	private boolean salaCongressi;
	private boolean ascensore;
	private boolean ariaCondizionata;
	private boolean riscaldamento;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private TipologiaStruttura tipologiaStruttura;
	
	private int numeroStelle;
	
	@OneToMany(mappedBy="struttura", cascade=CascadeType.ALL)
	private List<DisponibilitaCamere> disponibilitaCamere;
	
	@ManyToMany(mappedBy="strutture", cascade=CascadeType.ALL)
	private List<TipoSoggiorno> tipiSoggiorno;
	
	@OneToMany(mappedBy="struttura", cascade=CascadeType.ALL)
	private List<Pernottamento> pernottamenti;
	
	
	public int getIdStruttura() {
		return idStruttura;
	}
	public void setIdStruttura(int idStruttura) {
		this.idStruttura = idStruttura;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Luogo getLuogo() {
		return luogo;
	}
	public void setLuogo(Luogo luogo) {
		this.luogo = luogo;
	}
	public double getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(double latitudine) {
		this.latitudine = latitudine;
	}
	public double getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(double longitudine) {
		this.longitudine = longitudine;
	}
	public boolean isPiscina() {
		return piscina;
	}
	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}
	public boolean isParcheggio() {
		return parcheggio;
	}
	public void setParcheggio(boolean parcheggio) {
		this.parcheggio = parcheggio;
	}
	public boolean isAnimaliAmmessi() {
		return animaliAmmessi;
	}
	public void setAnimaliAmmessi(boolean animaliAmmessi) {
		this.animaliAmmessi = animaliAmmessi;
	}
	public boolean isSalaGiochi() {
		return salaGiochi;
	}
	public void setSalaGiochi(boolean salaGiochi) {
		this.salaGiochi = salaGiochi;
	}
	public boolean isSalaCongressi() {
		return salaCongressi;
	}
	public void setSalaCongressi(boolean salaCongressi) {
		this.salaCongressi = salaCongressi;
	}
	public boolean isAscensore() {
		return ascensore;
	}
	public void setAscensore(boolean ascensore) {
		this.ascensore = ascensore;
	}
	public boolean isAriaCondizionata() {
		return ariaCondizionata;
	}
	public void setAriaCondizionata(boolean ariaCondizionata) {
		this.ariaCondizionata = ariaCondizionata;
	}
	public boolean isRiscaldamento() {
		return riscaldamento;
	}
	public void setRiscaldamento(boolean riscaldamento) {
		this.riscaldamento = riscaldamento;
	}
	public TipologiaStruttura getTipologiaStruttura() {
		return tipologiaStruttura;
	}
	public void setTipologiaStruttura(TipologiaStruttura tipologiaStruttura) {
		this.tipologiaStruttura = tipologiaStruttura;
	}
	public int getNumeroStelle() {
		return numeroStelle;
	}
	public void setNumeroStelle(int numeroStelle) {
		this.numeroStelle = numeroStelle;
	}
	public List<DisponibilitaCamere> getDisponibilitaCamere() {
		return disponibilitaCamere;
	}
	public void setDisponibilitaCamere(List<DisponibilitaCamere> disponibilitaCamere) {
		this.disponibilitaCamere = disponibilitaCamere;
	}
	public List<TipoSoggiorno> getTipiSoggiorno() {
		return tipiSoggiorno;
	}
	public void setTipiSoggiorno(List<TipoSoggiorno> tipiSoggiorno) {
		this.tipiSoggiorno = tipiSoggiorno;
	}
	public List<Pernottamento> getPernottamenti() {
		return pernottamenti;
	}
	public void setPernottamenti(List<Pernottamento> pernottamenti) {
		this.pernottamenti = pernottamenti;
	}
	
	

}
