package applicazione.progetto.travelplan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by FRANCESCO on 06/02/2018.
 */

public class UtenteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "utente.db";
    private static final int DATABASE_VERSION = 1;

    // Lo statement SQL di creazione del database
    private static final String DATABASE_CREATE = "create table utente (_id integer primary key autoincrement, nome text not null, cognome text not null,email text not null,password text not null, dataNascita date not null);";

    // Costruttore
    public UtenteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Questo metodo viene chiamato durante la creazione del database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    // Questo metodo viene chiamato durante l'upgrade del database, ad esempio quando viene incrementato il numero di versione
    @Override
    public void onUpgrade( SQLiteDatabase database, int oldVersion, int newVersion ) {
        database.execSQL("DROP TABLE IF EXISTS utente");
        onCreate(database);
    }
}
