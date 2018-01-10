package com.lezzi.androidsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antoniolezzi on 18/12/2017.
 */

public class ContactDBAdapter {


    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public ContactDBAdapter(Context context) {
        this.context = context;
    }

    public ContactDBAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();

        return this;
    }

    public void close() {
        dbHelper.close();
        database.close();
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    void addContact(Contact contact) {
        open();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_CONTACT_NAME, contact.getName());
        values.put(DatabaseHelper.KEY_CONTACT_PHONE, contact.getPhoneNumber());

        database.insert(DatabaseHelper.TABLE_CONTACTS, null, values);

        close();
    }

    Contact getContact(int id) {
        open();

        Cursor cursor = database.query(DatabaseHelper.TABLE_CONTACTS, new String[] {DatabaseHelper.KEY_CONTACT_ID,
                        DatabaseHelper.KEY_CONTACT_NAME, DatabaseHelper.KEY_CONTACT_PHONE }, DatabaseHelper.KEY_CONTACT_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return contact;
    }

    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();

        String selectQuery = "SELECT  * FROM " + DatabaseHelper.TABLE_CONTACTS;

        open();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));

                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        return contactList;
    }

    public int updateContact(Contact contact) {
        open();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_CONTACT_NAME, contact.getName());
        values.put(DatabaseHelper.KEY_CONTACT_PHONE, contact.getPhoneNumber());

        return database.update(DatabaseHelper.TABLE_CONTACTS, values, DatabaseHelper.KEY_CONTACT_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }

    public void deleteContact(Contact contact) {
        open();
        database.delete(DatabaseHelper.TABLE_CONTACTS, DatabaseHelper.KEY_CONTACT_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        close();
    }


    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + DatabaseHelper.TABLE_CONTACTS;

        open();
        Cursor cursor = database.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

}
