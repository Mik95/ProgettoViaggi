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

import applicazione.progetto.travelplan.Activity.Login;
import applicazione.progetto.travelplan.R;

public class RegistrationFragment extends Fragment {

    public RegistrationFragment()
    {

    }

    EditText en;
    EditText ec;
    EditText ed;
    EditText ee;
    EditText ep;
    EditText ecp;

    TextView comp;
    TextView check;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_registration, container, false);

        Button conferma = (Button)rootView.findViewById(R.id.btnConferma);
        en = (EditText)rootView.findViewById(R.id.etNome);
        ec = (EditText)rootView.findViewById(R.id.etCognome);
        ee = (EditText)rootView.findViewById(R.id.etEmail);
        ep = (EditText)rootView.findViewById(R.id.etPass);
        ecp = (EditText)rootView.findViewById(R.id.etConfermaPass);

        comp = (TextView) rootView.findViewById(R.id.tvNonCompleto);
        check = (TextView) rootView.findViewById(R.id.tvCheckPass);

        //udba = new UtenteDBAdapter(getActivity());
        //udba.open();

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ee.getText().toString().isEmpty() || ec.getText().toString().isEmpty() || en.getText().toString().isEmpty() || ep.getText().toString().isEmpty() || ecp.getText().toString().isEmpty())
                {
                    comp.setVisibility(View.VISIBLE);

                }
                else
                {
                    if(ep.getText().toString().equals(ecp.getText().toString()))
                    {
                        Intent accedi = new Intent(getActivity(), Login.class);
                        accedi.putExtra("emailRegistrazione",ee.getText().toString());
                        accedi.putExtra("passRegistrazione",ep.getText().toString());
                        startActivity(accedi);
                    }
                    else
                    {
                        check.setVisibility(View.VISIBLE);
                    }
                }
            }
        });


        return rootView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
       // udba.close();
    }

}
