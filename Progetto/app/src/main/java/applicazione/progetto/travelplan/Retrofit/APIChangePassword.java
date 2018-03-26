package applicazione.progetto.travelplan.Retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by itsadmin on 23/03/2018.
 */

public interface APIChangePassword {

    @FormUrlEncoded
    @POST("changePassword")
    Call<Void> changePass(@Field("email") String email,@Field("password") String password);
}
