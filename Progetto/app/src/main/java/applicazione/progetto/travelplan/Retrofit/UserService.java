package applicazione.progetto.travelplan.Retrofit;

import applicazione.progetto.travelplan.ResObj;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by itsadmin on 19/03/2018.
 */

public interface UserService {

    @GET("login/[email]/[password]")
    Call<ResObj> login(@Path("email") String email,@Path("password") String password);


}
