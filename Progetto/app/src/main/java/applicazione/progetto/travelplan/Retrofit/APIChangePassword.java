package applicazione.progetto.travelplan.Retrofit;

import applicazione.progetto.travelplan.Models.RisultatoCambiaPass;
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
    Call<RisultatoCambiaPass> changePass(@Field("email") String email, @Field("password") String password);
}
