package com.example.butce_takip.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Database_Yeni extends SQLiteOpenHelper {

    public Database_Yeni(Context context) {
        super(context, "YeniBudget.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Tablo(id TEXT primary key ,kullanici_adi TEXT,sifre TEXT, islem_turu TEXT,tutar INTEGER,aciklama TEXT, tarih TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int v1, int v2) {
        DB.execSQL("drop Table if exists Tablo");
    }

    public Boolean insertdata(String id, String kullanici_adi, String sifre, String islem_turu, int tutar, String aciklama, String tarih) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("kullanici_adi", kullanici_adi);
        contentValues.put("sifre", sifre);
        contentValues.put("islem_turu", islem_turu);
        contentValues.put("tutar", tutar);
        contentValues.put("aciklama", aciklama);
        contentValues.put("tarih", tarih);
        long result=DB.insert("Tablo", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }


    public Boolean deletedata(String id) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Tablo where id = ?", new String[]{id});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Tablo", "id=?", new String[]{id});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata_gelir(String kullanici_adi) {
        SQLiteDatabase DB = this.getReadableDatabase();
      //  Cursor cursor = DB.rawQuery("Select * from Tablo where  islem_turu='Gelir' and kullanici_adi=?",new String[]{kullanici_adi});
       Cursor cursor = DB.rawQuery("Select * from Tablo  where islem_turu='Gelir' and kullanici_adi=?", new String[]{kullanici_adi});
        return cursor;
    }

    public Cursor getdata_gider(String kullanici_adi) {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Tablo where islem_turu='Gider' and kullanici_adi=?", new String[]{kullanici_adi});
        return cursor;
    }



    public String son_id() {
        SQLiteDatabase DB = this.getWritableDatabase();

        String toplam="";
        Cursor cursor = DB.rawQuery("Select id from Tablo order by id asc",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String tutar =cursor.getString(0);
            toplam=tutar;
            cursor.moveToNext();
        }
        cursor.close();

        return toplam;
    }




    public Boolean Giris_Kontrol(String kullanici_adi, String sifre) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("kullanici_adi", kullanici_adi);
        contentValues.put("sifre", sifre);
            Cursor cursor2 = DB.rawQuery("Select * from Tablo where kullanici_adi=? and sifre=?",new String[]{kullanici_adi,sifre});
            if (cursor2.getCount()>0) {
                return true;
            }
            else {
                return false;
            }
        }



    public int Gelir_Toplam(String kullanici_adi) {
        SQLiteDatabase DB = this.getWritableDatabase();

        int toplam=0;
        Cursor cursor = DB.rawQuery("Select tutar from Tablo where islem_turu='Gelir' and kullanici_adi=?",new String[]{kullanici_adi});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int tutar =cursor.getInt(0);
            toplam+=tutar;
            cursor.moveToNext();
        }

        cursor.close();

        return toplam;

    }

    public int Gider_Toplam(String kullanici_adi) {
        SQLiteDatabase DB = this.getWritableDatabase();

        int toplam=0;
        Cursor cursor = DB.rawQuery("Select tutar from Tablo where islem_turu='Gider' and kullanici_adi=?",new String[]{kullanici_adi});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int tutar =cursor.getInt(0);
            toplam+=tutar;
            cursor.moveToNext();
        }

        cursor.close();

        return toplam;

    }



}
