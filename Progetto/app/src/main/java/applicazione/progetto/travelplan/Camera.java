package applicazione.progetto.travelplan;

/**
 * Created by itsadmin on 20/02/2018.
 */

public class Camera {

    int id;
    String tipologia;
    String notte;
    String prezzo;
    String optional;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getNotte() {
        return notte;
    }

    public void setNotte(String notte) {
        this.notte = notte;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public String getOptional() {
        return optional;
    }

    public void setOptional(String optional) {
        this.optional = optional;
    }
}
