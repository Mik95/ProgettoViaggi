package applicazione.progetto.travelplan.Retrofit;

import java.util.ArrayList;

import applicazione.progetto.travelplan.Models.MezzoDiTrasporto;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by itsadmin on 21/03/2018.
 */

public interface MezziAPI {

    @GET("mezzi")
    Call <ArrayList<MezzoDiTrasporto>> getAllMezzi();
}
