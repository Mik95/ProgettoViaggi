package applicazione.progetto.travelplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends Activity {

    EditText en;
    EditText ec;
    EditText ed;
    EditText ee;
    EditText eu;
    EditText ep;
    EditText ecp;

    RadioButton f;
    RadioButton m;

    Button confe;

    TextView comp;
    TextView check;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        en = (EditText)findViewById(R.id.etNome);
        ec = (EditText)findViewById(R.id.etCognome);
        ed = (EditText)findViewById(R.id.etData);
        ee = (EditText)findViewById(R.id.etEmail);
        eu = (EditText)findViewById(R.id.etUser);
        ep = (EditText)findViewById(R.id.etPass);
        ecp = (EditText)findViewById(R.id.etConfermaPass);

        f = (RadioButton) findViewById(R.id.radioFemmina);
        m = (RadioButton) findViewById(R.id.radioMaschio);

        confe = (Button) findViewById(R.id.btnConferma);

        comp = (TextView) findViewById(R.id.tvNonCompleto);
        check = (TextView) findViewById(R.id.tvCheckPass);

        confe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (en.getText().toString().isEmpty()||ec.getText().toString().isEmpty()||ed.getText().toString().isEmpty()||ee.getText().toString().isEmpty()||eu.getText().toString().isEmpty()||ep.getText().toString().isEmpty()||ecp.getText().toString().isEmpty()||(!f.isChecked()&&!m.isChecked()))
                {
                    comp.setVisibility(View.VISIBLE);
                }
                else
                {
                    if(ep.getText().toString().equals(ecp.getText().toString()))
                    {
                        Toast.makeText(Registration.this,"Ti sei registrato",Toast.LENGTH_SHORT).show();
                        comp.setVisibility(View.INVISIBLE);
                        check.setVisibility(View.INVISIBLE);
                        final UtenteDBAdapter udba = new UtenteDBAdapter(Registration.this);
                        udba.insertData(en.getText().toString(), ec.getText().toString(),ee.getText().toString(),eu.getText().toString(), ep.getText().toString(), ed.getText().toString());
                        Intent i = new Intent(Registration.this,MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        check.setVisibility(View.VISIBLE);
                    }

                }
            }
        });


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioFemmina:
                if (checked)
                    m.setChecked(false);
                    break;
            case R.id.radioMaschio:
                if (checked)
                    f.setChecked(false);
                    break;
        }
    }


}
