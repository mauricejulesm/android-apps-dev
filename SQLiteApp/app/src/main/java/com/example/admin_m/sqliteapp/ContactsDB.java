package com.example.admin_m.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactsDB {
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "person_name";
    public static final String KEY_PHONE = "_phone";

    private  final  String DATABASE_NAME = "ContactsDB";
    private  final  String DATABASE_TABLE = "ContactsTable";
    private  final  int DATABASE_VERSION = 1;

    private  DBHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;

    public ContactsDB(Context context){
        ourContext = context;
    }

    private class DBHelper extends SQLiteOpenHelper{

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_TABLE);
            onCreate(db);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            String sqlCode = "CREATE TABLE " + DATABASE_TABLE + " ("+
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_NAME + " TEXT NOT NULL, " +
                    KEY_PHONE + " TEXT NOT NULL);";

            db.execSQL(sqlCode);

        }


    }
    public ContactsDB open() {
        ourHelper = new DBHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        ourHelper.close();
    }

    public long createEntry( String name, String phone){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,name);
        contentValues.put(KEY_PHONE,phone);

        return ourDatabase.insert(DATABASE_TABLE, null, contentValues);
    }

    public  String getData (){
        String [] columns = new String[] {KEY_ID, KEY_NAME, KEY_PHONE};
        Cursor  cursor = ourDatabase.query(DATABASE_TABLE, columns,null, null, null,null, null);

        String result = "";
        int iRowID = cursor.getColumnIndex(KEY_ID);
        int iName = cursor.getColumnIndex(KEY_NAME);
        int iPhoneNumber = cursor.getColumnIndex(KEY_PHONE);

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            result = result + cursor.getString(iRowID) + ": "+cursor.getString(iName)+ " "+
                        cursor.getString(iPhoneNumber) + "\n";

        }
        cursor.close();
        return result;
    }

    public  long deleteEntry( String rowID){
        return  ourDatabase.delete(DATABASE_TABLE, KEY_ID + "=?", new String[]{rowID});

    }
    public  long updateEntry(String rowID, String name, String phone){

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, name);
        contentValues.put(KEY_PHONE, phone);

        return  ourDatabase.update(DATABASE_TABLE,contentValues, KEY_ID + "=?", new String[]{rowID});


    }
}
