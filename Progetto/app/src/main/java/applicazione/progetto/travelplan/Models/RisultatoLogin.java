package applicazione.progetto.travelplan.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by itsadmin on 23/03/2018.
 */

public class RisultatoLogin {

    @SerializedName("success")
    boolean success;
    @SerializedName("messaggio")
    String message;
    @SerializedName("oggettoRisultante")
    Utente oggettoRisultante;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Utente getOggettoRisultante() {
        return oggettoRisultante;
    }

    public void setOggettoRisultante(Utente oggettoRisultante) {
        this.oggettoRisultante = oggettoRisultante;
    }
}
