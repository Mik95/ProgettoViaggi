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
    private static final String UTENTE_TABLE_COLUMN_ID = "_id"; // a column named "_id" is required for cursor
    public static final String UTENTE_TABLE_COLUMN_NAME = "nome";
    public static final String UTENTE_TABLE_COLUMN_COGNOME = "cognome";
    public static final String UTENTE_TABLE_COLUMN_EMAIL = "email";
    public static final String UTENTE_TABLE_COLUMN_PASSWORD = "password";
    public static final String UTENTE_TABLE_COLUMN_DATANASCITA = "dataNascita";

    private Context context;
    private UtenteHelper openHelper;
    private SQLiteDatabase database;

    public UtenteDBAdapter(Context aContext) {
        openHelper = new UtenteHelper(aContext);
       // database = openHelper.getWritableDatabase();
    }

    public void open() throws SQLException {
        openHelper = new UtenteHelper(context);
        database = openHelper.getWritableDatabase();
    }

    public void close() {
        openHelper.close();
        database.close();
    }

    public void insertData (String name, String surname, String email,String password, String dataNascita) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(UTENTE_TABLE_COLUMN_NAME, name);
        contentValues.put(UTENTE_TABLE_COLUMN_COGNOME, surname);
        contentValues.put(UTENTE_TABLE_COLUMN_EMAIL, email);
        contentValues.put(UTENTE_TABLE_COLUMN_PASSWORD, password);
        contentValues.put(UTENTE_TABLE_COLUMN_DATANASCITA, dataNascita);

        database.insert(TABLE_NAME, null, contentValues);
    }

    public Cursor getAllData () {
        String buildSQL = "SELECT * FROM " + TABLE_NAME;
        Log.d("UtenteDBAdapter", "getAllData SQL: " + buildSQL);

        return database.rawQuery(buildSQL, null);
    }


    public boolean controlloNomeCognomeUtente(String nome, String cognome) {
        String buildSQL = "SELECT * FROM " + TABLE_NAME + "WHERE EXISTS " + UTENTE_TABLE_COLUMN_NAME + " LIKE '" + nome + "AND" + UTENTE_TABLE_COLUMN_COGNOME+ " LIKE '" + cognome + "'";
        Log.d("UtenteDBAdapter", "getAllData SQL: " + buildSQL);

        return true;
    }

    public boolean controlloLoginUtente(String email, String password) {
        String buildSQL = "SELECT * FROM " + TABLE_NAME + "WHERE EXISTS " + UTENTE_TABLE_COLUMN_EMAIL + " LIKE '" + email + "AND'" + UTENTE_TABLE_COLUMN_PASSWORD+ " LIKE '" + password + "'";
        Log.d("UtenteDBAdapter", "getAllData SQL: " + buildSQL);

        return true;
    }

    public boolean controlloEmail(String email) {
        String buildSQL = "SELECT * FROM " + TABLE_NAME + "WHERE EXISTS " + UTENTE_TABLE_COLUMN_EMAIL + " LIKE '" + email + "'";
        Log.d("UtenteDBAdapter", "getAllData SQL: " + buildSQL);

        return true;
    }

    /*public Cursor getUtente (String cognome) {
        Cursor c = database.rawQuery("SELECT * FROM " + TABLE_NAME + "WHERE" + UTENTE_TABLE_COLUMN_COGNOME + "LIKE " + cognome, null );
        Log.d("UtenteDBAdapter", "getAllData SQL: ");

        return c;
    }*/

    public Cursor getUtente (String nome) {

        Cursor c = null;

        try {


            String buildSQL = "SELECT * FROM " + TABLE_NAME + " WHERE " + UTENTE_TABLE_COLUMN_NAME + " LIKE '" + nome + "'";
            Log.d ( "StrutturaDBAdapter", "getCitta SQL: " + buildSQL );

            c = database.rawQuery ( buildSQL, null );
        }
        catch (Exception ex) {
            Log.d ( "StrutturaDBAdapter", ex.getMessage () );
        }
        return c;
    }

    public void deleteUtente(int row) {

        // Deletes a row given its rowId, but I want to be able to pass
        // in the name of the KEY_NAME and have it delete that row.
        database.delete(TABLE_NAME, UTENTE_TABLE_COLUMN_ID + "=" + row, null);
    }



}
