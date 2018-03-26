package applicazione.progetto.travelplan.Retrofit;

import java.util.ArrayList;

import applicazione.progetto.travelplan.Models.PacchettoViaggio;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * Created by itsadmin on 23/03/2018.
 */

public interface APIPacchetto {

    @FormUrlEncoded
    @GET("pacchetti")
    Call<ArrayList<PacchettoViaggio>> getPacchettoViaggio();
    @FormUrlEncoded
    @GET("deletePack")
    Call<Void> deletePacchettoViaggio(@Field("idPacchetto") int id);
}
