package applicazione.progetto.travelplan.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import applicazione.progetto.travelplan.Fragment.DialogFragment.ChiudiApp;
import applicazione.progetto.travelplan.Fragment.RegistrationFragment;
import applicazione.progetto.travelplan.Models.MezzoDiTrasporto;
import applicazione.progetto.travelplan.Models.RisultatoLogin;
import applicazione.progetto.travelplan.R;
import applicazione.progetto.travelplan.Retrofit.APILoginRegistration;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by itsadmin on 22/02/2018.
 */

public class Login extends Activity {

    EditText eU;
    EditText eP;
    TextView te;
    TextView tp;
    Button ac;
    ImageView sfondo;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       final RisultatoLogin rl = new RisultatoLogin();

        te= (TextView)findViewById(R.id.tve);
        tp= (TextView)findViewById(R.id.tvp);

        eU = (EditText)findViewById(R.id.etlEmail);
        eP = (EditText)findViewById(R.id.etPass);
        ac = (Button)findViewById(R.id.btnAccedi);

      final  ArrayList <MezzoDiTrasporto> mezzoArrayList = new ArrayList<>();


        //Retrofit
        //userService = RestUserApi.getUserServise();

        final TextView seiReg = (TextView)findViewById(R.id.tvSeiRegistrato);
        final FrameLayout fr = (FrameLayout)findViewById(R.id.r);

        String password = eP.getText().toString();


        //Passaggio email e password dal fragment registrazione alla pagina di login
        Bundle bu =getIntent().getExtras();
        if(bu!=null)
        {
          //  sfondo.setVisibility(View.INVISIBLE);
            //fermaContatore(c);
            String e = bu.getString("emailRegistrazione");
            String p = bu.getString("passRegistrazione");
            eU.setText(e);
            eP.setText(p);

        }


        seiReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                getFragmentManager().beginTransaction().replace(R.id.r, new RegistrationFragment()).commit();


            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(eU.getText().toString().isEmpty()||eP.getText().toString().isEmpty())
                {
                    Toast.makeText(Login.this,"Riempi tutti i campi!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    final String email = eU.getText().toString();
                    final String password= eP.getText().toString();

                   // rl.setOggettoRisultante(new Utente(email,password));

                    Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/TravelPlanSito/").addConverterFactory(GsonConverterFactory.create());
                    Retrofit retrofit = builder.build();

                    APILoginRegistration logAPI = retrofit.create(APILoginRegistration.class);

                    Call<RisultatoLogin> call = logAPI.controlloLogin(eU.getText().toString(),eP.getText().toString());

                    call.enqueue(new retrofit2.Callback<RisultatoLogin>() {
                        @Override
                        public void onResponse(Call<RisultatoLogin> call, Response<RisultatoLogin> response) {

                            if (response.body().isSuccess()){

                                Intent i = new Intent(Login.this, Home.class);
                                startActivity(i);
                            }



                            //Toast.makeText(Login.this,"Utente non presente",Toast.LENGTH_SHORT).show();

                             /*for (Utente u : response.body()){

                                    arrayUtente.add(u);
                                    if(arrayUtente.contains(u.controlloUtente(email,password)))
                                    {

                                    }
                                 else {
                                        Toast.makeText(Login.this,"Registrati!",Toast.LENGTH_SHORT).show();
                                    }
                                    //System.out.println(u.getNome());
                                }*/
                        }

                        @Override
                        public void onFailure(Call<RisultatoLogin> call, Throwable t) {

                            Toast.makeText(Login.this,"Utente non registrato",Toast.LENGTH_SHORT).show();

                            System.out.println(t.getMessage());
                            System.out.println(t.getCause());
                        }
                    });


                  /*  Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://192.168.1.22:8080/TravelPlanSito/").addConverterFactory(GsonConverterFactory.create());
                    Retrofit retrofit = builder.build();

                    APIUtente apiUtente = retrofit.create(APIUtente.class);

                    Call<Utente> call = apiUtente.controlloUtente();

                   call.enqueue(new retrofit2.Callback<Utente>()
                   {
                       @Override
                       public void onResponse(Call<Utente> call, Response<Utente> response) {

                       }

                       @Override
                       public void onFailure(Call<Utente> call, Throwable t) {

                       }
                   });*/


                   /*final UtenteDBAdapter ua=new UtenteDBAdapter(Login.this);
                    if(ua.controlloLoginUtente(email,password))
                    {*/

                       /* if(validateLogin(email,password))
                        {
                            doLogin(email,password);
                        }
                        Intent i = new Intent(Login.this, Home.class);
                        //i.putExtra("Username", email);
                        startActivity(i);
                   /* }/*
                    else
                    {
                        Toast.makeText(Login.this,"Non sei registrato!",Toast.LENGTH_SHORT).show();
                    }*/

                }

            }
        });
    }


    @Override
    public void onBackPressed() {

        Intent login = new Intent(Login.this,Login.class);
        login.putExtra("Back","");
        startActivity(login);
        super.onBackPressed();
        new ChiudiApp().show(getFragmentManager(), "Chiudi App");

    }


}
