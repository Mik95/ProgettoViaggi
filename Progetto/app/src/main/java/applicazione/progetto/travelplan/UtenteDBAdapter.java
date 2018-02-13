package applicazione.progetto.travelplan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Date;

/**
 * Created by FRANCESCO on 06/02/2018.
 */

public class UtenteDBAdapter {
    private static final String TABLE_NAME = "utente";  // Table name
    private static final String STRUTTURA_TABLE_COLUMN_ID = "_id"; // a column named "_id" is required for cursor
    public static final String STRUTTURA_TABLE_COLUMN_NAME = "nome";
    public static final String STRUTTURA_TABLE_COLUMN_COGNOME = "cognome";
    public static final String STRUTTURA_TABLE_COLUMN_EMAIL = "email";
    public static final String STRUTTURA_TABLE_COLUMN_USERNAME = "userName";
    public static final String STRUTTURA_TABLE_COLUMN_PASSWORD = "password";
    public static final String STRUTTURA_TABLE_COLUMN_DATANASCITA = "dataNascita";

    private Context context;
    private UtenteHelper openHelper;
    private SQLiteDatabase database;

    public UtenteDBAdapter(Context aContext) {
        openHelper = new UtenteHelper(aContext);
        database = openHelper.getWritableDatabase();
    }

    public UtenteDBAdapter open() throws SQLException {
        openHelper = new UtenteHelper(context);
        database = openHelper.getWritableDatabase();

        return this;
    }

    public void close() {
        openHelper.close();
        database.close();
    }

    public void insertData (String name, String surname, String email, String userName, String password, String dataNascita) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(STRUTTURA_TABLE_COLUMN_NAME, name);
        contentValues.put(STRUTTURA_TABLE_COLUMN_COGNOME, surname);
        contentValues.put(STRUTTURA_TABLE_COLUMN_EMAIL, email);
        contentValues.put(STRUTTURA_TABLE_COLUMN_USERNAME, userName);
        contentValues.put(STRUTTURA_TABLE_COLUMN_PASSWORD, password);
        contentValues.put(STRUTTURA_TABLE_COLUMN_DATANASCITA, dataNascita);

        database.insert(TABLE_NAME, null, contentValues);
    }

    public Cursor getAllData () {
        String buildSQL = "SELECT * FROM " + TABLE_NAME;
        Log.d("UtenteDBAdapter", "getAllData SQL: " + buildSQL);

        return database.rawQuery(buildSQL, null);
    }


    public boolean controlloUtente(String nome, String cognome) {
        String buildSQL = "SELECT * FROM " + TABLE_NAME + "WHERE EXISTS " + nome + cognome;
        Log.d("UtenteDBAdapter", "getAllData SQL: " + buildSQL);

        return true;
    }

    public Cursor getUtente (String cognome) {
        Cursor c = database.rawQuery("SELECT * FROM " + TABLE_NAME + "WHERE" + STRUTTURA_TABLE_COLUMN_COGNOME + "LIKE " + cognome, null );
        Log.d("UtenteDBAdapter", "getAllData SQL: ");

        return c;
    }

    public void deleteUtente(int row) {

        // Deletes a row given its rowId, but I want to be able to pass
        // in the name of the KEY_NAME and have it delete that row.
        database.delete(TABLE_NAME, STRUTTURA_TABLE_COLUMN_ID + "=" + row, null);
    }



}
