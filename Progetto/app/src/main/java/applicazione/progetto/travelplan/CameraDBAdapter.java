package applicazione.progetto.travelplan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Camera;
import android.util.Log;

/**
 * Created by itsadmin on 20/02/2018.
 */

public class CameraDBAdapter {
    private static final String TABLE_NAME = "camera";  // Table name
    public static final String ROOM_TABLE_COLUMN_ID = "_id"; // a column named "_id" is required for cursor
    public static final String ROOM_TABLE_COLUMN_TYPE = "tipo";
    public static final String ROOM_TABLE_COLUMN_NIGHT = "notte";
    public static final String ROOM_TABLE_COLUMN_PRICE = "prezzo";
    public static final String ROOM_TABLE_COLUMN_OPTIONAL = "optional";

    private Context context;
    private CameraHelper openHelper;
    private SQLiteDatabase database;

    public CameraDBAdapter(Context aContext) {
        context = aContext;
        /*openHelper = new DatabaseHelper(aContext);
        database = openHelper.getWritableDatabase();*/
    }

    public void open() throws SQLException {
        openHelper = new CameraHelper(context);
        database = openHelper.getWritableDatabase();
    }

    public void close() {
        openHelper.close();
        database.close();
    }

    public void insertData (String cameraTipo, String notte,String cameraPrezzo, String cameraOptional) {
        ContentValues contentValues = new ContentValues();

        //contentValues.put (ROOM_TABLE_COLUMN_ID, id);
        contentValues.put(ROOM_TABLE_COLUMN_TYPE, cameraTipo);
        contentValues.put(ROOM_TABLE_COLUMN_NIGHT, notte);
        contentValues.put(ROOM_TABLE_COLUMN_PRICE, cameraPrezzo);
        contentValues.put(ROOM_TABLE_COLUMN_OPTIONAL, cameraOptional);


        database.insert(TABLE_NAME, null, contentValues);
    }

    public Cursor getAllData () {
        String buildSQL = "SELECT * FROM " + TABLE_NAME;
        Log.d("CameraDBAdapter", "getAllData SQL: " + buildSQL);

        return database.rawQuery(buildSQL, null);
    }

  /*  public Cursor getCitta (String city) {

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
    }*/

    public void deleteCamera(int row) {

        // Deletes a row given its rowId, but I want to be able to pass
        // in the name of the KEY_NAME and have it delete that row.
        database.delete(TABLE_NAME, ROOM_TABLE_COLUMN_ID + "=" + row, null);
    }



}
