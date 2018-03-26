package applicazione.progetto.travelplan.Retrofit;

import java.util.ArrayList;

import applicazione.progetto.travelplan.Models.Luogo;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by itsadmin on 26/03/2018.
 */

public interface APILuoghi {

    @GET("luoghi")
    Call<ArrayList<Luogo>> getLuoghi();
}
