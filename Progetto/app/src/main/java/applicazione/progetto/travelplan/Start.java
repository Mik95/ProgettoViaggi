package applicazione.progetto.travelplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Start extends Activity {

    int timeout = 1500;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.start );





        new Handler ().postDelayed( new Runnable()
        {
            @Override
            public void run()
            {
                Intent i = new Intent(Start.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, timeout);
    }
}
