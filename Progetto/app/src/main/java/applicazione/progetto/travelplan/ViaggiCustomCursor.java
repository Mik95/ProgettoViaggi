package applicazione.progetto.travelplan;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by itsadmin on 20/02/2018.
 */

public class ViaggiCustomCursor extends CursorAdapter {

    private Context context;


    public ViaggiCustomCursor(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View retView = inflater.inflate(R.layout.item_viaggi_layout, parent, false);

        return retView;
    }

    @Override
    public void bindView(View view, Context c, Cursor cursor) {



        final TextView h1= view.findViewById ( R.id.txtipologia);
        TextView i1= view.findViewById ( R.id.txnotte );
        TextView i2= view.findViewById ( R.id.txprezzo );
        TextView c1= view.findViewById ( R.id.txoptional);



       /* h1.setText(cursor.getString(cursor.getColumnIndex(CameraDBAdapter.ROOM_TABLE_COLUMN_TYPE)));
        i1.setText(cursor.getString(cursor.getColumnIndex(CameraDBAdapter.ROOM_TABLE_COLUMN_NIGHT)));
        i2.setText(cursor.getString(cursor.getColumnIndex(CameraDBAdapter.ROOM_TABLE_COLUMN_PRICE)));
        c1.setText(cursor.getString(cursor.getColumnIndex(CameraDBAdapter.ROOM_TABLE_COLUMN_OPTIONAL)));*/




    }
}
