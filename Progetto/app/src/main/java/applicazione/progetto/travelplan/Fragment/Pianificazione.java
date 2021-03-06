package applicazione.progetto.travelplan.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import applicazione.progetto.travelplan.Activity.Home;
import applicazione.progetto.travelplan.Models.Luogo;
import applicazione.progetto.travelplan.R;
import applicazione.progetto.travelplan.Retrofit.APILuoghi;
import applicazione.progetto.travelplan.Retrofit.APIPacchetto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Pianificazione extends Fragment{

    Button tv;
    Button cp;
    ListView list;
    TextView data;
    EditText edData;
    TextView txArrivocity;
    TextView txPartenzaCity;
    IBinder windowToken;

    ImageView persone;
    EditText personeEd;
    int p=0;

    //Stringhe utilizzate per il passaggio di parametri con il Fragment dei dettagli
    String nome = null;
    String indirizzo= null;
    //Stringhe utilizzate per il passaggio di parametri con il Fragment dei dettagli
    String cittaPae=null;
    String cittaAae=null;
    String oraPae=null;
    String oraAae=null;

    ArrayList<String> dett = new ArrayList<String>();
    ArrayAdapter<String> st;


    EditText cittaP;
    EditText cittaA;

    ArrayList<Luogo> luogo = new ArrayList<>();
    Luogo trovato = new Luogo();

    public Pianificazione()
    {

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Home.closeKeyboard(getActivity(),windowToken);
        View rootView = inflater.inflate(R.layout.fragment_pianificazione, container, false);
        list = (ListView) rootView.findViewById(R.id.aggiuntaPiano);
        st = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, dett);

        tv = (Button) rootView.findViewById ( R.id.btTermina );
        cp = (Button) rootView.findViewById ( R.id.btConfermaViaggio );
        cittaP =(EditText) rootView.findViewById(R.id.edCityPartenza);
        cittaA =(EditText) rootView.findViewById(R.id.edCityArrivo);
        txArrivocity = (TextView) rootView.findViewById ( R.id.txCityArrivo );
        txPartenzaCity = (TextView) rootView.findViewById ( R.id.txCityPartenza );
        persone = (ImageView) rootView.findViewById(R.id.people);
        personeEd = (EditText) rootView.findViewById(R.id.edPeople);
        data = (TextView) rootView.findViewById(R.id.txData);
        edData = (EditText) rootView.findViewById(R.id.edData);

        if(getActivity().getIntent()!=null)
        {
            ((Home)getActivity()).getIncomingIntent(dett,st,list);
        }


       persone.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               p+=1;
               personeEd.setText(String.valueOf(p));

           }
       });


        Bundle b = getArguments();
        if(b!=null)
        {

               nome = b.getString("NomeHotel");
                indirizzo = b.getString("IndirizzoHotel");
                if(nome!= null && indirizzo!= null)
                {
                    dett.add(nome);
                    dett.add(indirizzo);
                    st.notifyDataSetChanged();
                    list.setAdapter(st);
                    ((Home)getActivity()).getIncomingIntent(dett,st,list);
                }
                cittaPae=b.getString("Cittaa");
                cittaAae=b.getString("Cittaa");
                oraPae=b.getString("Orap");
                oraAae=b.getString("Oraa");
            if(cittaPae!= null && cittaAae!= null && oraPae!= null && oraAae!= null)
            {
                dett.add(cittaPae);
                dett.add(cittaAae);
                dett.add(oraPae);
                dett.add(oraAae);
                st.notifyDataSetChanged();
                list.setAdapter(st);
                ((Home)getActivity()).getIncomingIntent(dett,st,list);
                data.setText("Arrivo");
            }




        }
        //Cliccandolo porta al Fragment della ricerca
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getFragmentManager().beginTransaction().replace(R.id.frame, new ResearchFragment()).commit();

            }
        });

        //Cliccandolo rimuove i dati aggiunti nella listView della Pianificazione
        FloatingActionButton fabo = (FloatingActionButton) rootView.findViewById(R.id.fabRemove);
        fabo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                dett.remove(cittaPae);
                dett.remove(cittaAae);
                dett.remove(oraPae);
                dett.remove(oraAae);
                st.notifyDataSetChanged();
                list.setAdapter(st);
                getFragmentManager().beginTransaction().replace(R.id.frame, new Pianificazione()).commit();

            }
        });
        //vado nel fragment dei mezzi di trasporto
        cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cittaA.length()>0 && cittaP.length()>0 && personeEd.getText().toString()!=null)
                {
                    getFragmentManager().beginTransaction().add(R.id.frame, new RicercaMezziFragment()).commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Compila tutti i campi!",Toast.LENGTH_SHORT).show();
                }


            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // new ConfermaTerminaPiano().show(getFragmentManager(), "Conferma termina piano");
                Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/TravelPlanSito/").addConverterFactory(GsonConverterFactory.create());
                Retrofit retrofit = builder.build();

                APILuoghi apLuoghi = retrofit.create(APILuoghi.class);

                Call<ArrayList<Luogo>> call = apLuoghi.getLuoghi();

                call.enqueue(new Callback<ArrayList<Luogo>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Luogo>> call, Response<ArrayList<Luogo>> response) {


                        for (Luogo l : response.body()){

                            luogo.add(l);

                            //System.out.println(m.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Luogo>> call, Throwable t) {

                        System.out.println("FAILURE");
                    }
                });

                if(luogo.contains(cittaP.getText().toString()))
                {
                    trovato.setId(luogo.indexOf(cittaP.getText().toString()));
                }
                else
                {
                    Toast.makeText(getActivity(),"Città non presente nel database!",Toast.LENGTH_SHORT).show();
                }

                Retrofit.Builder builde = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/TravelPlanSito/").addConverterFactory(GsonConverterFactory.create());
                Retrofit retrofi = builde.build();

                APIPacchetto packAPI = retrofi.create(APIPacchetto.class);

                Call<Integer> callpack = packAPI.creaPacchetto(p,trovato.getId(),cittaP.getText().toString(),edData.getText().toString());

                callpack.enqueue(new retrofit2.Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {

                        if (response.body().equals(trovato.getId())){

                            Toast.makeText(getActivity(),"Creazione pacchetto avvenuta",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(getActivity(),"Luogo non trovato",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {

                        System.out.println(t.getMessage());
                        System.out.println(t.getCause());
                    }
                });




            }
        });

        return rootView;
    }
       /* final ArrayList<DettagliHotelFragment> lista = new ArrayList<>();
        // lista.add(new Model("Pino",4,1));

        final DettagliAdapter adpt = new DettagliAdapter(this);*/




       //Metodo per conertire da data a stringa
    private Date ConvertToDate(String dateString){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return convertedDate;
    }

}