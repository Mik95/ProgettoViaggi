package applicazione.progetto.travelplan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Research extends Activity {

    String n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);
        n=getIntent().getStringExtra("Username");
        TextView uname =(TextView) findViewById(R.id.tvnome);
        uname.setText(String.valueOf(n));
    }
}
