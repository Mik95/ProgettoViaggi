package applicazione.progetto.travelplan.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import applicazione.progetto.travelplan.R;

public class SettingsFragment extends Fragment {

    Switch simpleSwitch;
    TextView sito,info;
    WebView web;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        simpleSwitch = (Switch) rootView.findViewById(R.id.switchAttivo); // initiate Switch
        sito = (TextView) rootView.findViewById(R.id.tInfo);
        info = (TextView) rootView.findViewById(R.id.txInfo);
        web = (WebView) rootView.findViewById(R.id.webview);


        sito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                simpleSwitch.setVisibility(View.INVISIBLE);
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
                simpleSwitch.setVisibility(View.INVISIBLE);
                sito.setVisibility(View.INVISIBLE);
                info.setVisibility(View.INVISIBLE);
                web.loadUrl("http://www.google.it");
            }
        });

        simpleSwitch.setTextOn("On"); // displayed text of the Switch whenever it is in checked or on state
        simpleSwitch.setTextOff("Off"); // displayed text of the Switch whenever it is in unchecked i.e. off state



        return rootView;
    }


}
