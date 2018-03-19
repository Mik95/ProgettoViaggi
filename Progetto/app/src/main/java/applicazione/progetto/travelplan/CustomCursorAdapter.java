package applicazione.progetto.travelplan;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by itsadmin on 29/01/2018.
 */

public class CustomCursorAdapter extends CursorAdapter{

    private Context context;


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
    public void bindView(View view, Context c, Cursor cursor) {



        final TextView hotel1= view.findViewById ( R.id.hotel1 );
        TextView indirizzo1= view.findViewById ( R.id.indirizzo1 );
        TextView citta1= view.findViewById ( R.id.citaH1);

        hotel1.setText(cursor.getString(cursor.getColumnIndex(StrutturaDBAdapter.STRUTTURA_TABLE_COLUMN_NAME)));
        indirizzo1.setText(cursor.getString(cursor.getColumnIndex(StrutturaDBAdapter.STRUTTURA_TABLE_COLUMN_ID)));
        citta1.setText(cursor.getString(cursor.getColumnIndex(StrutturaDBAdapter.STRUTTURA_TABLE_COLUMN_CITTA)));




    }

}