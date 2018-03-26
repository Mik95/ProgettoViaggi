package applicazione.progetto.travelplan.Activity;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.IBinder;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import applicazione.progetto.travelplan.Fragment.DettagliHotelFragment;
import applicazione.progetto.travelplan.Fragment.FragmentMain;
import applicazione.progetto.travelplan.Fragment.Pianificazione;
import applicazione.progetto.travelplan.Fragment.ResearchFragment;
import applicazione.progetto.travelplan.Fragment.RicercaMezziFragment;
import applicazione.progetto.travelplan.Fragment.SettingsFragment;
import applicazione.progetto.travelplan.Fragment.ViaggiFragment;
import applicazione.progetto.travelplan.R;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Fragments

    //Arraylist che gestisce i fragments
    ArrayList<Fragment> fr = new ArrayList<>();

    //Stringhe per il passaggio i parametri dall'adapter dell'aereo alla pianificazione
    String cittaPartenzaAereo =null;
    String cittaArrivoAereo =null;
    String oraPartenzaAereo= null;
    String oraArrivoAereo= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gestioneFragments();
        getFragmentManager().beginTransaction().replace(R.id.frame, new FragmentMain()).commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        //Se ricevo i parametri dall fragment dei dettagli hotel vado alla Pianificazione
        if (getIntent().hasExtra("NomeHotel") && getIntent().hasExtra("IndirizzoHotel"))
        {
            getFragmentManager().beginTransaction().replace(R.id.frame,new DettagliHotelFragment()).commit();
        }


        //Se clicco una delle recyclerView presenti nella home allora vado nel fragment dei dettagli dell'hotel
        if(getIntent().hasExtra("Offerta") || getIntent().hasExtra("Popolari"))
        {
            getFragmentManager().beginTransaction().replace(R.id.frame,new DettagliHotelFragment()).commit();

        }
        //Se ricevo i parametri dalla recyclerView dell'Aereo vado alla Pianificazione
        if (getIntent().hasExtra("CittaPartenzaAereo") && getIntent().hasExtra("CittaArrivoAereo") && getIntent().hasExtra("OraPartenzaAereo") && getIntent().hasExtra("OraArrivoAereo"))
        {
            getFragmentManager().beginTransaction().replace(R.id.frame,new Pianificazione()).commit();
        }

        //Se ricevo i parametri dalla recyclerView del pullman vado alla Pianificazione
        if(getIntent().hasExtra("CittaPartenzaPullman") && getIntent().hasExtra("CittaArrivoPullman") && getIntent().hasExtra("OraPartenzaPullman") && getIntent().hasExtra("OraArrivoPullman"))
        {
            getFragmentManager().beginTransaction().replace(R.id.frame,new Pianificazione()).commit();
        }

        //Se ricevo i parametri dalla recyclerView dell'Auto vado alla Pianificazione
        if(getIntent().hasExtra("CittaPartenzaAuto") && getIntent().hasExtra("CittaArrivoAuto") && getIntent().hasExtra("OraPartenzaAuto") && getIntent().hasExtra("OraArrivoAuto") && getIntent().hasExtra("Automobile"))
        {
            getFragmentManager().beginTransaction().replace(R.id.frame,new Pianificazione()).commit();
        }

        //Se ricevo i parametri dalla recyclerView del Treno vado alla Pianificazione
        if (getIntent().hasExtra("CittaPartenzaTreno") && getIntent().hasExtra("CittaArrivoTreno") && getIntent().hasExtra("OraPartenzaTreno") && getIntent().hasExtra("OraArrivoTreno"))
        {
            getFragmentManager().beginTransaction().replace(R.id.frame,new Pianificazione()).commit();
        }




        BottomNavigationView bottom = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.home:
                        getFragmentManager().beginTransaction().replace(R.id.frame, new FragmentMain()).commit();
                        break;
                    case R.id.create_travel_plan:
                        getFragmentManager().beginTransaction().replace(R.id.frame, new Pianificazione()).commit();
                        break;
                    case R.id.my_travels:
                        getFragmentManager().beginTransaction().replace(R.id.frame, new ViaggiFragment()).commit();
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
      /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        else {


        }*/

        super.onBackPressed();

      /*Fragment fpiani = new Pianificazione();

      ArrayList<Fragment> f = new ArrayList<>();
      f=gestioneFragmentsBack();
      if(f.contains(fpiani))
      {
          getFragmentManager().beginTransaction().hide(fpiani);
      }
      */


        return;
    }

    private ArrayList<Fragment> gestioneFragmentsBack()
    {
        //Inizializzazione gestione fragment
       /* Fragment main = new FragmentMain();
        Fragment piano;
        Fragment ricerca;
        Fragment dettagli;
        Fragment mezzo;
        Fragment impostazioni;
        Fragment viaggi;
        main = new FragmentMain();
        piano = new Pianificazione();
        ricerca = new ResearchFragment();
        dettagli = new DettagliHotelFragment();
        mezzo = new RicercaMezziFragment();
        impostazioni = new SettingsFragment();
        viaggi = new ViaggiFragment();
        fr.add(main);
        fr.add(piano);
        fr.add(ricerca);
        fr.add(dettagli);
        fr.add(mezzo);
        fr.add(impostazioni);
        fr.add(viaggi);*/

        return fr;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        android.support.v4.app.Fragment frag = null;

        if (id == R.id.fragmentSettings) {
            //frag = new SettingsFragment();

            getFragmentManager().beginTransaction().replace(R.id.frame, new SettingsFragment()).commit();
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        switch (id) {
            case R.id.set:
                getFragmentManager().beginTransaction().replace(R.id.frame, new SettingsFragment()).commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private FragmentTransaction controlloFragment(Fragment fragment, ArrayList<Fragment> fr) {
        if (fr.contains(fragment)) {
            switch (fr.indexOf(fragment)) {
                case 0:
                    //Fragment frag = new FragmentMain();
                    break;
                case 1:

                    break;
                case 2:
                    getFragmentManager().beginTransaction().replace(R.id.frame, new ResearchFragment());
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
            }
        } else {
            Toast.makeText(Home.this, "Aggiungi un nuovo fragment", Toast.LENGTH_SHORT).show();
        }
        return getFragmentManager().beginTransaction().replace(R.id.frame, new FragmentMain());
    }

    @Override
    protected void onDestroy() {
        fr.clear();
        super.onDestroy();

    }

    public void getIncomingIntent(ArrayList<String> dett, ArrayAdapter<String> st, ListView list) {
        if (getIntent().hasExtra("NomeHotel") && getIntent().hasExtra("IndirizzoHotel")) {
            String nome = getIntent().getStringExtra("NomeHotel");
            String indirizzo = getIntent().getStringExtra("IndirizzoHotel");
            dett.add(nome);
            dett.add(indirizzo);
            st.notifyDataSetChanged();
            list.setAdapter(st);
            getIncomingIntent(dett,st,list);

        } else {
            if (getIntent().hasExtra("CittaPartenzaAereo") && getIntent().hasExtra("CittaArrivoAereo") && getIntent().hasExtra("OraPartenzaAereo") && getIntent().hasExtra("OraArrivoAereo")) {
                String cittaPartenza = getIntent().getExtras().getString("CittaPartenzaAereo");
                String cittaArrivo = getIntent().getExtras().getString("CittaArrivoAereo");
                String oraPartenza = getIntent().getExtras().getString("OraPartenzaAereo");
                String oraArrivo = getIntent().getExtras().getString("OraArrivoAereo");
                dett.add(cittaPartenza + " " + oraPartenza + " " + cittaArrivo + " " + oraArrivo);
                st.notifyDataSetChanged();
                list.setAdapter(st);
                getIncomingIntent(dett,st,list);

            } else {
                if (getIntent().hasExtra("CittaPartenzaPullman") && getIntent().hasExtra("CittaArrivoPullman") && getIntent().hasExtra("OraPartenzaPullman") && getIntent().hasExtra("OraArrivoPullman")) {

                    String cittaPartenza = getIntent().getStringExtra("CittaPartenzaPullman");
                    String cittaArrivo = getIntent().getStringExtra("CittaArrivoPullman");
                    String oraPartenza = getIntent().getStringExtra("OraPartenzaPullman");
                    String oraArrivo = getIntent().getStringExtra("OraArrivoPullman");

                    dett.add(cittaPartenza + " " + oraPartenza + " " + cittaArrivo + " " + oraArrivo);
                    st.notifyDataSetChanged();
                    list.setAdapter(st);
                    getIncomingIntent(dett,st,list);

                } else {
                    if (getIntent().hasExtra("CittaPartenzaAuto") && getIntent().hasExtra("CittaArrivoAuto") && getIntent().hasExtra("OraPartenzaAuto") && getIntent().hasExtra("OraArrivoAuto") && getIntent().hasExtra("Automobile")) {
                        String cittaPartenza = getIntent().getStringExtra("CittaPartenzaAuto");
                        String cittaArrivo = getIntent().getStringExtra("CittaArrivoAuto");
                        String oraPartenza = getIntent().getStringExtra("OraPartenzaAuto");
                        String oraArrivo = getIntent().getStringExtra("OraArrivoAuto");
                        String auto = getIntent().getStringExtra("Automobile");
                        dett.add("Hai usa l' " + auto + " " + cittaPartenza + " " + oraPartenza + " " + cittaArrivo + " " + oraArrivo);
                        st.notifyDataSetChanged();
                        list.setAdapter(st);
                        getIncomingIntent(dett,st,list);

                    } else {
                        if (getIntent().hasExtra("CittaPartenzaTreno") && getIntent().hasExtra("CittaArrivoTreno") && getIntent().hasExtra("OraPartenzaTreno") && getIntent().hasExtra("OraArrivoTreno")) {
                            String cittaPartenza = getIntent().getStringExtra("CittaPartenzaTreno");
                            String cittaArrivo = getIntent().getStringExtra("CittaArrivoTreno");
                            String oraPartenza = getIntent().getStringExtra("OraPartenzaTreno");
                            String oraArrivo = getIntent().getStringExtra("OraArrivoTreno");

                            dett.add(cittaPartenza + " " + oraPartenza + " " + cittaArrivo + " " + oraArrivo);
                            st.notifyDataSetChanged();
                            list.setAdapter(st);
                            getIncomingIntent(dett,st,list);

                        }
                    }
                }
            }

        }
    }

    public void gestioneFragments()
    {
        //Inizializzazione gestione fragment
        /*main = new FragmentMain();
        piano = new Pianificazione();
        ricerca = new ResearchFragment();
        dettagli = new DettagliHotelFragment();
        mezzo = new RicercaMezziFragment();
        impostazioni = new SettingsFragment();
        viaggi = new ViaggiFragment();
        fr.add(main);
        fr.add(piano);
        fr.add(ricerca);
        fr.add(dettagli);
        fr.add(mezzo);
        fr.add(impostazioni);
        fr.add(viaggi);*/
    }

    public static void closeKeyboard(Context c, IBinder windowToken) {
        InputMethodManager mgr = (InputMethodManager) c.getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(windowToken, 0);
    }



}
