package com.lezzi.androidsqlite;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    TextView demoTextView;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        demoTextView = (TextView)findViewById(R.id.demoTextView);
        button = (Button)findViewById(R.id.button);

        final ContactDBAdapter db = new ContactDBAdapter(this);
        
        db.addContact(new Contact("Antonio", "320123456789"));
        db.addContact(new Contact("Pippo", "330987456321"));
        db.addContact(new Contact("Pluto", "310147852369"));
        db.addContact(new Contact("Paperino", "340546821793"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demoTextView.setText("");

                // Reading all contacts
                Log.d("MainActivity ", "Lettura di tutti i contatti");
                List<Contact> contacts = db.getAllContacts();

                for (Contact cn : contacts) {
                    String log = "Id: "+cn.getID()+" , None: " + cn.getName() + " , Cell: " + cn.getPhoneNumber() + "\n";
                    demoTextView.setText(demoTextView.getText().toString() + log);
                }
            }
        });
    }
}