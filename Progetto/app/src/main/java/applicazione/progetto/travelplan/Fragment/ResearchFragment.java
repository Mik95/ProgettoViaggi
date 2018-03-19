package applicazione.progetto.travelplan.Fragment;
import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import applicazione.progetto.travelplan.CustomCursorAdapter;
import applicazione.progetto.travelplan.Fragment.DettagliHotelFragment;
import applicazione.progetto.travelplan.R;
import applicazione.progetto.travelplan.StrutturaDBAdapter;

public class ResearchFragment extends Fragment{


    Button cerca;
    EditText ricerca;

    StrutturaDBAdapter sdba = null;

    public ResearchFragment()
    {

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_research, container, false);
        final ListView lv = (ListView)rootView.findViewById(R.id.list);
        cerca =(Button) rootView.findViewById(R.id.btnCerca);
        ricerca = (EditText) rootView.findViewById(R.id.etRicerca);

        sdba = new StrutturaDBAdapter(getActivity());
        sdba.open ();
        sdba.insertData(1,"Palace", "Milano");
        sdba.insertData(2,"Hilton", "Milano");
        sdba.insertData(3,"Price", "Roma");
        sdba.insertData(4,"Queen", "Trieste");




        final CustomCursorAdapter cca = new CustomCursorAdapter(getActivity(), sdba.getAllData ());
        //final CustomCursorAdapter cca = new CustomCursorAdapter(this, sdba.getCitta ( "Milano" ));
        lv.setAdapter(cca);
       /*final List<Struttura> hotel = new ArrayList<Struttura>();
        final ArrayAdapter<Struttura> listaHotel = new ArrayAdapter<Struttura>(this,android.R.layout.simple_list_item_1,hotel);
*/
       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               cca.getItem(position);
               getFragmentManager().beginTransaction().replace(R.id.frame, new DettagliHotelFragment()).commit();


           }
       });
        cerca.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {

                                         String citta=ricerca.getText().toString();
                                         if(!citta.isEmpty() && citta.length()>0)
                                         {
                                             Cursor cu = sdba.getCitta ( citta );
                                             cca.changeCursor ( cu );
                                             cca.notifyDataSetChanged ();


                                         }


                                     }

                                 }
        );



        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy ();

        sdba.close ();
    }
}
