package applicazione.progetto.travelplan;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Research extends Activity {
    Button cerca;
    EditText ricerca;
    TextView uname;

    StrutturaDBAdapter sdba = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);

        uname =(TextView) findViewById(R.id.tvBenvenuto);
        cerca = (Button) findViewById(R.id.btnCerca);
        ricerca = (EditText) findViewById(R.id.etRicerca);


       sdba = new StrutturaDBAdapter(this);
       sdba.open ();
        /*sdba.insertData(1,"Palace", "Milano");
        sdba.insertData(2,"Hilton", "Milano");
        sdba.insertData(3,"Price", "Roma");
        sdba.insertData(4,"Queen", "Trieste");
*/


       final ListView lv = (ListView)findViewById(R.id.list);
        final CustomCursorAdapter cca = new CustomCursorAdapter(this, sdba.getAllData ());
        //final CustomCursorAdapter cca = new CustomCursorAdapter(this, sdba.getCitta ( "Milano" ));
        lv.setAdapter(cca);
       /*final List<Struttura> hotel = new ArrayList<Struttura>();
        final ArrayAdapter<Struttura> listaHotel = new ArrayAdapter<Struttura>(this,android.R.layout.simple_list_item_1,hotel);
*/
        cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        String citta=ricerca.getText().toString();
                        if(!citta.isEmpty() && citta.length()>0)
                        {
                            Cursor cu = sdba.getCitta ( citta );
                            //Cursor cu = sdba.getAllData ();
                            cca.changeCursor ( cu );
                            cca.notifyDataSetChanged ();
                            //CustomCursorAdapter ccu = new CustomCursorAdapter(Research.this, sdba.getCitta(citta));
                            //Cursor c = sdba.getAllData();
                            //lv.setAdapter(ccu);

                                }
                             else{
                                Toast.makeText(Research.this, "non entra", Toast.LENGTH_SHORT).show();
                            }


                }

            }
        );

        cerca.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                /*sdba.deleteStruttura(1);
                sdba.deleteStruttura(2);
                sdba.deleteStruttura(3);
                sdba.deleteStruttura(4);
                sdba.deleteStruttura(5);
                sdba.deleteStruttura(6);
                sdba.deleteStruttura(7);
                sdba.deleteStruttura(8);
                sdba.deleteStruttura(9);
                sdba.deleteStruttura(10);
                sdba.deleteStruttura(11);
                sdba.deleteStruttura(12);
                sdba.deleteStruttura(13);
                sdba.deleteStruttura(14);
                sdba.deleteStruttura(15);
                sdba.deleteStruttura(16);
                sdba.deleteStruttura(17);
                sdba.deleteStruttura(18);
                sdba.deleteStruttura(19);
                sdba.deleteStruttura(20);
                sdba.deleteStruttura(21);
                sdba.deleteStruttura(22);
                sdba.deleteStruttura(23);
                sdba.deleteStruttura(24);
                sdba.deleteStruttura(25);
                sdba.deleteStruttura(26);
                sdba.deleteStruttura(27);
                sdba.deleteStruttura(28);
                sdba.deleteStruttura(29);
                sdba.deleteStruttura(30);
                sdba.deleteStruttura(31);
                sdba.deleteStruttura(32);
                sdba.deleteStruttura(33);
                sdba.deleteStruttura(34);
                sdba.deleteStruttura(35);*/

                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();

        sdba.close ();
    }
}
