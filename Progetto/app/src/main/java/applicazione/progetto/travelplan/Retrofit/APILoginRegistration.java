package applicazione.progetto.travelplan.Retrofit;


import java.util.ArrayList;

import applicazione.progetto.travelplan.Models.RisultatoLogin;
import applicazione.progetto.travelplan.Models.RisultatoReg;
import applicazione.progetto.travelplan.Models.Utente;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by itsadmin on 23/03/2018.
 */

public interface APILoginRegistration {

    @FormUrlEncoded
    @POST("login")
    Call<RisultatoLogin> controlloLogin(@Field("email") String email, @Field("password") String password);
    @FormUrlEncoded
    @POST("registration")
    Call<RisultatoReg> controlloRegistration(@Field("name") String name, @Field("lastname") String lastname, @Field("password2") String password, @Field("email2") String email);




}
