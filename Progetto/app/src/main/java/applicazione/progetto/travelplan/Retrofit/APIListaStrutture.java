package applicazione.progetto.travelplan.Retrofit;

import java.util.ArrayList;

import applicazione.progetto.travelplan.Models.Tappa;
import applicazione.progetto.travelplan.Struttura;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * Created by itsadmin on 23/03/2018.
 */

public interface APIListaStrutture {

    @FormUrlEncoded
    @GET("listaStrutture")
    Call<ArrayList<Struttura>> getStrutture();
}
