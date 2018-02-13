package applicazione.progetto.travelplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Pianificazione extends Activity {


    EditText ep;
    EditText ea;
    Button tv;
    Button cp;
    ImageButton bg;
    String n;
    TextView tb;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_pianificazione );
        n=getIntent().getStringExtra("Username");
        ep = (EditText)findViewById ( R.id.edPArtenza );
        ea = (EditText)findViewById ( R.id.edArrivo );
        tv = (Button)findViewById ( R.id.btTermina );
        cp = (Button)findViewById ( R.id.btConfermaViaggio );
        bg = (ImageButton)findViewById ( R.id.imgAggiungi );
        tb = (TextView) findViewById ( R.id.txBenvenuto );
        tb.setText("Benvenuto, " + String.valueOf(n));


        bg.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick( View view ) {
                Intent i = new Intent ( Pianificazione.this, Research.class);
                startActivity ( i );
            }
        } );
    }


}
