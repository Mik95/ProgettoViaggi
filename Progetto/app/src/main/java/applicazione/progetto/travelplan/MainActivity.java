package applicazione.progetto.travelplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText eU;
    EditText eP;
    Button ac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eU = (EditText) findViewById(R.id.etUsername);
        eP = (EditText) findViewById(R.id.etPass);
        ac = (Button) findViewById(R.id.btnAccedi);

        final TextView seiReg = (TextView) findViewById(R.id.tvSeiRegistrato);


        String password = eP.getText().toString();

        seiReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,Registration.class);
                startActivity(i);


            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(eU.getText().toString().isEmpty()||eP.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Riempi tutti i campi!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new Intent(MainActivity.this,Pianificazione.class);
                    String username = eU.getText().toString();
                    i.putExtra("Username",username);
                    startActivity(i);
                }

            }
        });


    }
}
