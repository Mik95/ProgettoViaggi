package applicazione.progetto.travelplan.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import applicazione.progetto.travelplan.Fragment.DialogFragment.ChiudiApp;
import applicazione.progetto.travelplan.Fragment.RegistrationFragment;
import applicazione.progetto.travelplan.Models.Utente;
import applicazione.progetto.travelplan.R;
import applicazione.progetto.travelplan.ResObj;
import applicazione.progetto.travelplan.Retrofit.Api;
import applicazione.progetto.travelplan.Retrofit.UserService;
import retrofit2.Call;
import retrofit2.Callback;
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
   // UserService userService;
    //private String server_url = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        //Retrofit
      /*  Retrofit retrofit = new Retrofit.Builder().
                             baseUrl(Api.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create()).build();

           Api api = retrofit.create(Api.class);

           Call<List<Utente>> call = api.getUtente();

           call.enqueue(new Callback<List<Utente>>()
           {
               @Override
               public void onResponse( Call<List<Utente>> call, Response<List<Utente>> response)
               {
                   List<Utente> utenti = response.body();

                   for(Utente u : utenti)
                   {
                       Log.d("email", u.getEmail());
                       Log.d("password",u.getPassword());
                   }
               }

               @Override
               public void onFailure(Call<List<Utente>> call,Throwable t)
               {
                   Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
               }

           });*/


        te= (TextView)findViewById(R.id.tve);
        tp= (TextView)findViewById(R.id.tvp);

        eU = (EditText)findViewById(R.id.etlEmail);
        eP = (EditText)findViewById(R.id.etPass);
        ac = (Button)findViewById(R.id.btnAccedi);
        sfondo = (ImageView)findViewById(R.id.im);

        //Retrofit
        //userService = Api.getUserServise();

        final TextView seiReg = (TextView)findViewById(R.id.tvSeiRegistrato);
        final FrameLayout fr = (FrameLayout)findViewById(R.id.r);

        String password = eP.getText().toString();

       CountDownTimer c = new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {

                te.setVisibility(View.INVISIBLE);
                tp.setVisibility(View.INVISIBLE);
                eU.setVisibility(View.INVISIBLE);
                eP.setVisibility(View.INVISIBLE);
                ac.setVisibility(View.INVISIBLE);
                seiReg.setVisibility(View.INVISIBLE);
            }

            public void onFinish() {

                sfondo.setVisibility(View.GONE);
                te.setVisibility(View.VISIBLE);
                tp.setVisibility(View.VISIBLE);
                eU.setVisibility(View.VISIBLE);
                eP.setVisibility(View.VISIBLE);
                ac.setVisibility(View.VISIBLE);
                seiReg.setVisibility(View.VISIBLE);
            }
        }.start();
        //Passaggio email e password dal fragment registrazione alla pagina di login
        Bundle bu =getIntent().getExtras();
        if(bu!=null)
        {
            sfondo.setVisibility(View.INVISIBLE);
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
                    String email = eU.getText().toString();
                    String password= eP.getText().toString();

                    Intent i = new Intent(Login.this, Home.class);
                    //i.putExtra("Username", email);
                    startActivity(i);
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
