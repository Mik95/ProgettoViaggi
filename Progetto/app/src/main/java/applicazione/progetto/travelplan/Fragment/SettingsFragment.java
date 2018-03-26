package applicazione.progetto.travelplan.Fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import applicazione.progetto.travelplan.Activity.Login;
import applicazione.progetto.travelplan.R;

public class SettingsFragment extends Fragment {


    TextView sito,info,logout,mioprofilo;
    WebView web;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        logout = (TextView) rootView.findViewById(R.id.logout);
        sito = (TextView) rootView.findViewById(R.id.tInfo);
        info = (TextView) rootView.findViewById(R.id.txInfo);
        mioprofilo = (TextView) rootView.findViewById(R.id.impoprofilo);
        web = (WebView) rootView.findViewById(R.id.webview);



        sito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logout.setVisibility(View.INVISIBLE);
                sito.setVisibility(View.INVISIBLE);
                info.setVisibility(View.INVISIBLE);
                web.setVisibility(View.VISIBLE);
                web.loadUrl("http://www.google.it");

            }
        });

        info.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                web.setVisibility(View.VISIBLE);
                logout.setVisibility(View.INVISIBLE);
                sito.setVisibility(View.INVISIBLE);
                info.setVisibility(View.INVISIBLE);
                web.loadUrl("http://www.google.it");
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent log = new Intent(getActivity(), Login.class);
                startActivity(log);
                Toast.makeText(getActivity(),"Hai effettuato il logout!",Toast.LENGTH_SHORT).show();
            }
        });

        mioprofilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.frame,new ProfiloFragment()).commit();
            }
        });






        return rootView;
    }


}
