package applicazione.progetto.travelplan.Fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import applicazione.progetto.travelplan.CustomSwipeAdapter;
import applicazione.progetto.travelplan.R;

public class DettagliHotelFragment extends Fragment {

    ViewPager viewPager;
    CustomSwipeAdapter csa;
    Button sceltaMezzo,confermaCamera;
    TextView albergo,indirizzo;

    public DettagliHotelFragment()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.fragment_dettagli_hotel, container, false);
        viewPager = (ViewPager) root.findViewById(R.id.viewPager);
        csa = new CustomSwipeAdapter(getActivity());
        viewPager.setAdapter(csa);
        confermaCamera =(Button) root.findViewById(R.id.btSelCamera);
        albergo = (TextView) root.findViewById(R.id.edDesc);
        indirizzo =(TextView) root.findViewById(R.id.txInd);

//        mListener = (FragmentInteractionListener) getActivity();

        confermaCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getFragmentManager().beginTransaction().replace(R.id.frame, new Pianificazione()).commit();
                String hotel = albergo.getText().toString();
                String address = indirizzo.getText().toString();
                Bundle bundl = new Bundle();
                bundl.putString("NomeHotel", hotel);
                bundl.putString("IndirizzoHotel", address);

                Pianificazione dv = new Pianificazione();
                dv.setArguments(bundl);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame,dv);
                ft.show(getFragmentManager().findFragmentById(R.id.frame));
                ft.addToBackStack(null);
                ft.commit();

                /*Intent i = new Intent(getActivity(),Home.class);
                    i.putExtra("NomeHotel", hotel);
                    i.putExtra("IndirizzoHotel", address);
                    startActivity(i);*/
                    /*FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frame,dv);
                    ft.show(getFragmentManager().findFragmentById(R.id.frame));
                    ft.addToBackStack(null);
                    ft.commit();*/
            }
        });

        return root;
    }



}
