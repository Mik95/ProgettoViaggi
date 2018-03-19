package applicazione.progetto.travelplan;

/**
 * Created by itsadmin on 29/01/2018.
 */

public class Struttura {

    private int id;
    String nome;
    String citta;
    float prezzo;

    public Struttura(String c)
    {
        this.citta=c;
    }

    public Struttura(String ci,String n, float p)
    {
        this.citta=ci;
        this.nome=n;
        this.prezzo=p;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public Struttura(String n, String c)
    {
        this.nome=n;

        this.citta=c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}
