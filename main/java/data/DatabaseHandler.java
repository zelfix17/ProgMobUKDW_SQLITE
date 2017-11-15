package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import models.Dokter;

/**
 * Created by erick on 30/10/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, "DokterDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //membuat database
        String strSql = "create table Dokter (itemID integer primary key autoincrement,"+
                "Nama text, Alamat text, Nia text)";
        sqLiteDatabase.execSQL(strSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Dokter");
        onCreate(sqLiteDatabase);
    }

    public void AddDokter(Dokter dokter){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Nama",dokter.getNama());
        values.put("Alamat",dokter.getAlamat());
        values.put("Nia",dokter.getNia());
        db.insert("Dokter",null,values);
        db.close();
    }

    public void DeleteDokter(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Dokter","itemID=?",
                new String[]{String.valueOf(id)});
        db.close();
    }

    public void UpdateDokter(Dokter dokter){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Nama",dokter.getNama());
        values.put("Nia",dokter.getNia());
        values.put("Alamat",dokter.getAlamat());
        db.update("Dokter",values,"itemID=?",
                new String[]{String.valueOf(dokter.getItemID())});
        db.close();
    }

    public Dokter GetDokterById(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Dokter where itemID=?",
                new String[]{String.valueOf(id)});
        if(cursor!=null){
            cursor.moveToFirst();
        }

        Dokter dokter = new Dokter();
        dokter.setItemID(cursor.getInt(cursor.getColumnIndex("itemID")));
        dokter.setNama(cursor.getString(cursor.getColumnIndex("Nama")));
        dokter.setNia(cursor.getString(cursor.getColumnIndex("Nia")));
        dokter.setAlamat(cursor.getString(cursor.getColumnIndex("Alamat")));

        db.close();
        return dokter;
    }

    public ArrayList<Dokter> GetAllDokter(){
        ArrayList<Dokter> listDokter = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Dokter order by Nama asc",null);
        if(cursor.moveToFirst()){
            do{
                Dokter dokter = new Dokter();
                dokter.setItemID(cursor.getInt(cursor.getColumnIndex("itemID")));
                dokter.setNama(cursor.getString(cursor.getColumnIndex("Nama")));
                dokter.setNia(cursor.getString(cursor.getColumnIndex("Nia")));
                dokter.setAlamat(cursor.getString(cursor.getColumnIndex("Alamat")));
                listDokter.add(dokter);
            }while (cursor.moveToNext());
        }
        db.close();
        return listDokter;
    }
}
