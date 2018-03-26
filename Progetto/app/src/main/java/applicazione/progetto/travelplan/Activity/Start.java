package applicazione.progetto.travelplan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import applicazione.progetto.travelplan.R;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_start );

        int timeout = 2000;

            new Handler ().postDelayed( new Runnable()
            {
                @Override
                public void run()
                {
                    Intent i = new Intent(Start.this, Login.class);
                    startActivity(i);
                    finish();
                }
            }, timeout);

        }
}
