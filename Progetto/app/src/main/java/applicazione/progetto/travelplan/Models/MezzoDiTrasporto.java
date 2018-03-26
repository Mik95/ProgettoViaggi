package applicazione.progetto.travelplan.Models;


import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MezzoDiTrasporto {

	@SerializedName("idMezzoDiTrasporto")
	int id;
	@SerializedName("tipoMezzo")
	String tipo;
	@SerializedName("data")
	String data;
	@SerializedName("ora")
	String ora;
	@SerializedName("prezzo")
	double prezzo;
	@SerializedName("partenza")
	Luogo partenza;
	@SerializedName("arrivo")
	Luogo arrivo;

	public MezzoDiTrasporto(int id, String tipo, String data, String ora, double prezzo, Luogo partenza, Luogo arrivo) {
		this.id = id;
		this.tipo = tipo;
		this.data = data;
		this.ora = ora;
		this.prezzo = prezzo;
		this.partenza = partenza;
		this.arrivo = arrivo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Luogo getPartenza() {
		return partenza;
	}

	public void setPartenza(Luogo partenza) {
		this.partenza = partenza;
	}

	public Luogo getArrivo() {
		return arrivo;
	}

	public void setArrivo(Luogo arrivo) {
		this.arrivo = arrivo;
	}

	@Override
	public String toString (){

		return "Ciao sono " +tipo;
	}
	

}
