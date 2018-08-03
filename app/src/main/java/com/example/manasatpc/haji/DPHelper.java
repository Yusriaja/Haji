package com.example.manasatpc.haji;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.manasatpc.haji.TaskContract.HAjiEntry;

/**
 * Created by ManasatPC on 01/08/18.
 */

public class DPHelper  extends SQLiteOpenHelper {
    //the name of the database
    public static final String DATABASE_NAME = "stores.db";
    Context mContext;

    // If you change the database schema, you must increment the database version
    private static final int VERSION = 6;

    public DPHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Table MASTER
        final String CREATE_TABLE_MASTER =
                "CREATE TABLE "                    + HAjiEntry.TABLE_HAJI_MASTER  + " ("                 + HAjiEntry._ID    +
                        " INTEGER PRIMARY KEY, "   + HAjiEntry.HAJI_SEQ           + " TEXT NOT NULL, "+
                        HAjiEntry.FIRST_NAME       + " TEXT NOT NULL, "           + HAjiEntry.LAST_NAME  + " TEXT NOT NULL,"+
                        HAjiEntry.PASSWORD         + " INTEGER,"                  + HAjiEntry.PHONE_MASTER + " TEXT,"       +
                         HAjiEntry.EMAIL + " TEXT,"       +HAjiEntry.USER_ADMIN       + " INTEGER"                      + ")" ;
        db.execSQL(CREATE_TABLE_MASTER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + HAjiEntry.TABLE_HAJI_MASTER);
        onCreate(db);
    }


    public long addUserAdmin(ItemHaji itemHaji){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HAjiEntry.HAJI_SEQ,itemHaji.getSequance());
        values.put(HAjiEntry.FIRST_NAME,itemHaji.getFirst_name());
        values.put(HAjiEntry.LAST_NAME,itemHaji.getLast_name());
        values.put(HAjiEntry.EMAIL,itemHaji.getEmail());
        values.put(HAjiEntry.PHONE_MASTER,itemHaji.getPhone());
        values.put(HAjiEntry.PASSWORD,itemHaji.getPassword());
        values.put(HAjiEntry.USER_ADMIN,itemHaji.getUser_admin());

         //Insert row
        long user_id = db.insert(HAjiEntry.TABLE_HAJI_MASTER,null,values);
        return user_id;
    }
    //____________________Check data exist or not______________________
    public boolean isUserORAdmonExseit(String id_sequance){
        String whereClause = HAjiEntry.HAJI_SEQ +"=?";
        String [] whereArgs = new String[]{id_sequance};
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor search = db.query(HAjiEntry.TABLE_HAJI_MASTER,null,whereClause,whereArgs,null,null,null);
        boolean exist = (search.getCount() > 0);
        search.close();db.close();
        return exist;
    }
    //____________________Check data exist or not______________________
    public boolean isUserFound(String username, String password){
        String whereClause = HAjiEntry.FIRST_NAME +"=?";
        // && HAjiEntry.PASSWORD + "?"
        String [] whereArgs = new String[]{username,password};
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor search = db.query(HAjiEntry.TABLE_HAJI_MASTER,null,whereClause,whereArgs,null,null,null);
        boolean exist = (search.getCount() > 0);
        search.close();db.close();
        return exist;
    }

}
