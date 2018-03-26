package applicazione.progetto.travelplan.Retrofit;

import java.util.ArrayList;

import applicazione.progetto.travelplan.Models.Tappa;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by itsadmin on 23/03/2018.
 */

public interface APITappe {

    @FormUrlEncoded
    @POST("tappa")
    Call<Void> creaTappa(@Field("idMezzo") int idMezzo,@Field("idStruttura") int idStruttura,@Field("idPacchetto") int idPacchetto,@Field("data") String data);
    @GET("tappe")
    Call<ArrayList<Tappa>> getTappe();
}
