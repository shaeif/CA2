package com.uni.ca_2;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.CREATE_IF_NECESSARY;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class databaseService extends SQLiteOpenHelper {
        public databaseService(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table cab0008 (start_point varChar(20), end_point varChar(20),cab_type varChar(20))");
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inserRecord(String s_start, String s_end, String s_cab){
            SQLiteDatabase db= this.getWritableDatabase();
            db.execSQL("insert into cab0008 values (?,?,?)",new String[]{s_start,s_end,s_cab});
            Log.i("Status", "Done");

        }

        public void deleteRecord(String s_start){
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("delete from cab0008 where start_point=(?)",new String[]{s_start});
            Log.i("Status", "Done");

        }

    }