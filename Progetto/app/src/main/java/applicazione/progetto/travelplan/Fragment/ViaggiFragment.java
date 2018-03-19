package applicazione.progetto.travelplan.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import applicazione.progetto.travelplan.CameraDBAdapter;
import applicazione.progetto.travelplan.Fragment.DettagliHotelFragment;
import applicazione.progetto.travelplan.R;
import applicazione.progetto.travelplan.ViaggiCustomCursor;

public class ViaggiFragment extends Fragment {

    CameraDBAdapter cdba = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ViaggiFragment()
    {

    }

      @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

          View root=inflater.inflate(R.layout.fragment_viaggi, container, false);
          ListView lv = root.findViewById(R.id.listaViaggi);

          CameraDBAdapter s = new CameraDBAdapter(getActivity());
         // ViaggiCustomCursor va = new ViaggiCustomCursor(getActivity(),s.getAllData());

         // lv.setAdapter(va);
          //Istanzio cameraDbAdapter
          cdba = new CameraDBAdapter(getActivity());
          cdba.open();
         cdba.insertData("Matrimoniale","2"+ " "+ "notti","130" + "" + "euro","frigo"+ " "+"bar");
          final ViaggiCustomCursor va = new ViaggiCustomCursor(getActivity(),cdba.getAllData());
          lv.setAdapter(va);
          root.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

                  //va.getItem(va.getCount());
                  getFragmentManager().beginTransaction().replace(R.id.frame, new DettagliHotelFragment()).commit();
              }
          });
          /*new AdapterView.OnItemSelectedListener() {
              @Override
              public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                  va.getItem(i);
                  //mListener.onFragmentInteraction();
                  getFragmentManager().beginTransaction().replace(R.id.frame, new DettagliHotelFragment()).commit();
              }

              @Override
              public void onNothingSelected(AdapterView<?> adapterView) {

              }
          });*/

        return root;
    }

    @Override
    public void onDestroy() {
        super.onDestroy ();

        cdba.close ();
    }

}
