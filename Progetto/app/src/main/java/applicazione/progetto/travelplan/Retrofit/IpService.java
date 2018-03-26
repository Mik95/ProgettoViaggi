package applicazione.progetto.travelplan.Retrofit;

import applicazione.progetto.travelplan.Models.Ip;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by itsadmin on 19/03/2018.
 */

public interface IpService {

    @GET("/")
    Call<Ip> getIP();
}
