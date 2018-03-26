package applicazione.progetto.travelplan.Fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import applicazione.progetto.travelplan.Activity.Home;
import applicazione.progetto.travelplan.Activity.Login;
import applicazione.progetto.travelplan.Models.RisultatoCambiaPass;
import applicazione.progetto.travelplan.Models.RisultatoLogin;
import applicazione.progetto.travelplan.R;
import applicazione.progetto.travelplan.Retrofit.APIChangePassword;
import applicazione.progetto.travelplan.Retrofit.APILoginRegistration;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by checc_000 on 22/03/2018.
 */

public class FragmentCambiaPass extends Fragment {

    Button conferma;
    TextView tornaSettings;
    EditText email,password;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_cambiapass, container, false);
        email = (EditText) rootView.findViewById(R.id.edEmailChPass);
        password = (EditText) rootView.findViewById(R.id.edNuovaPass);

        conferma =(Button) rootView.findViewById(R.id.btConfermaCambioPass);
        tornaSettings = (TextView) rootView.findViewById(R.id.tornaImposta);

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (email.length() > 0 && password.length() > 0) {
                    Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/TravelPlanSito/").addConverterFactory(GsonConverterFactory.create());
                    Retrofit retrofit = builder.build();

                    APIChangePassword changeAPI = retrofit.create(APIChangePassword.class);

                    Call<RisultatoCambiaPass> call = changeAPI.changePass(email.getText().toString(), password.getText().toString());

                    call.enqueue(new retrofit2.Callback<RisultatoCambiaPass>() {
                        @Override
                        public void onResponse(Call<RisultatoCambiaPass> call, Response<RisultatoCambiaPass> response) {

                            if(response.body().isSuccess())
                            {
                                Toast.makeText(getActivity(), "Hai cambiato password!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getActivity(), "La password non è stata cambiata!", Toast.LENGTH_SHORT).show();
                            }


                        }

                        @Override
                        public void onFailure(Call<RisultatoCambiaPass> call, Throwable t) {

                            System.out.println(t.getMessage());
                            System.out.println(t.getCause());
                        }
                    });

                }
            }
        });

        tornaSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.frame, new SettingsFragment()).commit();
            }
        });
        return rootView;
    }

}
