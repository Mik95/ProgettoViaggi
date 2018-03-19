package applicazione.progetto.travelplan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import applicazione.progetto.travelplan.DatabaseHelper;

/**
 * Created by itsadmin on 29/01/2018.
 */

public class StrutturaDBAdapter {

    private static final String TABLE_NAME = "struttura";  // Table name
   public static final String STRUTTURA_TABLE_COLUMN_ID = "_id"; // a column named "_id" is required for cursor
    public static final String STRUTTURA_TABLE_COLUMN_NAME = "name";
    public static final String STRUTTURA_TABLE_COLUMN_CITTA = "citta";

    private Context context;
    private DatabaseHelper openHelper;
    private SQLiteDatabase database;

    public StrutturaDBAdapter(Context aContext) {
        context = aContext;
        /*openHelper = new DatabaseHelper(aContext);
        database = openHelper.getWritableDatabase();*/
    }

    public void open() throws SQLException {
        openHelper = new DatabaseHelper(context);
        database = openHelper.getWritableDatabase();
    }

    public void close() {
        openHelper.close();
        database.close();
    }

    public void insertData (int id,String strutturaName, String strutturaCitta) {
        ContentValues contentValues = new ContentValues();

        contentValues.put (STRUTTURA_TABLE_COLUMN_ID, id);
        contentValues.put(STRUTTURA_TABLE_COLUMN_NAME, strutturaName);
        contentValues.put(STRUTTURA_TABLE_COLUMN_CITTA, strutturaCitta);

        database.insert(TABLE_NAME, null, contentValues);
    }

    public Cursor getAllData () {
        String buildSQL = "SELECT * FROM " + TABLE_NAME;
        Log.d("StrutturaDBAdapter", "getAllData SQL: " + buildSQL);

        return database.rawQuery(buildSQL, null);
    }


    public Cursor getCitta (String city) {

        Cursor c = null;

        try {


            String buildSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + STRUTTURA_TABLE_COLUMN_CITTA + " LIKE '" + city + "'";
            Log.d ( "StrutturaDBAdapter", "getCitta SQL: " + buildSQL );

            c = database.rawQuery ( buildSQL, null );
        }
        catch (Exception ex) {
            Log.d ( "StrutturaDBAdapter", ex.getMessage () );
        }
        return c;
    }

    public void deleteStruttura(int row) {

        // Deletes a row given its rowId, but I want to be able to pass
        // in the name of the KEY_NAME and have it delete that row.
        database.delete(TABLE_NAME, STRUTTURA_TABLE_COLUMN_ID + "=" + row, null);
    }




}
