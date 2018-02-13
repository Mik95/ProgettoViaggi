package applicazione.progetto.travelplan;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import applicazione.progetto.travelplan.R;
import applicazione.progetto.travelplan.StrutturaDBAdapter;

/**
 * Created by itsadmin on 29/01/2018.
 */

public class CustomCursorAdapter extends CursorAdapter {
    public CustomCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View retView = inflater.inflate(R.layout.rowitem_layout, parent, false);

        return retView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView hotel1= view.findViewById ( R.id.hotel1 );
        TextView hotel2 = view.findViewById ( R.id.hotel2 );
        TextView hotel3 = view.findViewById ( R.id.hotel3 );

        TextView indirizzo1= view.findViewById ( R.id.indirizzo1 );
        TextView indirizzo2 = view.findViewById ( R.id.indirizzoH2 );
        TextView indirizzo3 = view.findViewById ( R.id.indirizzoH3);

        TextView citta1= view.findViewById ( R.id.citaH1);
        TextView citta2 = view.findViewById ( R.id.cittaH2 );
        TextView citta3 = view.findViewById ( R.id.citaH3);

        hotel1.setText(cursor.getString(cursor.getColumnIndex(StrutturaDBAdapter.STRUTTURA_TABLE_COLUMN_NAME)));
        hotel2.setText(cursor.getString(cursor.getColumnIndex(StrutturaDBAdapter.STRUTTURA_TABLE_COLUMN_NAME )));
        hotel3.setText(cursor.getString(cursor.getColumnIndex(StrutturaDBAdapter.STRUTTURA_TABLE_COLUMN_NAME )));

        indirizzo1.setText(cursor.getString(cursor.getColumnIndex(StrutturaDBAdapter.STRUTTURA_TABLE_COLUMN_ID)));
        indirizzo2.setText(cursor.getString(cursor.getColumnIndex(StrutturaDBAdapter.STRUTTURA_TABLE_COLUMN_ID)));
        indirizzo3.setText(cursor.getString(cursor.getColumnIndex(StrutturaDBAdapter.STRUTTURA_TABLE_COLUMN_ID )));

        citta1.setText(cursor.getString(cursor.getColumnIndex(StrutturaDBAdapter.STRUTTURA_TABLE_COLUMN_CITTA)));
        citta2.setText(cursor.getString(cursor.getColumnIndex(StrutturaDBAdapter.STRUTTURA_TABLE_COLUMN_CITTA)));
        citta3.setText(cursor.getString(cursor.getColumnIndex(StrutturaDBAdapter.STRUTTURA_TABLE_COLUMN_CITTA )));

    }
}