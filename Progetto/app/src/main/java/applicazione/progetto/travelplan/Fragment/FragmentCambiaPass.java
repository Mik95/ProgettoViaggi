package applicazione.progetto.travelplan.Fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import applicazione.progetto.travelplan.R;

/**
 * Created by checc_000 on 22/03/2018.
 */

public class FragmentCambiaPass extends Fragment {

    Button conferma;
    TextView tornaSettings;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_cambiapass, container, false);

        conferma =(Button) rootView.findViewById(R.id.btConfermaCambioPass);
        tornaSettings = (TextView) rootView.findViewById(R.id.tornaImposta);

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Hai cambiato password!", Toast.LENGTH_SHORT).show();
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
