package com.example.butce_takip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.butce_takip.Database.Database_Yeni;

import java.util.ArrayList;

public class gelir_goruntule extends AppCompatActivity {
    Database_Yeni DB;

    TextView ad;
    EditText gelirtoplami;
    ListView gelirler_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelir_goruntule);


        gelirler_list=findViewById(R.id.liste_gelir);
        ad=findViewById(R.id.gelirlistkullad);
        gelirtoplami=findViewById(R.id.gelirlistbakiye);

        DB = new Database_Yeni(this);

        /*Intent intent=getIntent();
        String kullad=intent.getStringExtra("kull");
        ad.setText(kullad);*/

        Cursor res = DB.getdata_gelir("merve");
        if(res.getCount()==0){

            int toplam=0;
            gelirtoplami.setText(String.valueOf(toplam));
            Toast.makeText(gelir_goruntule.this, "Gelir kaydınız yoktur!", Toast.LENGTH_SHORT).show();
            return;
        }

        ArrayList<String> arl = new ArrayList<String>();
        while(res.moveToNext()){
            StringBuffer buffer = new StringBuffer();
            buffer.append(res.getString(0)+".   ");
            String adi=res.getString(1);
            ad.setText(res.getString(1));
            buffer.append(res.getString(6)); //+"\n"
            buffer.append("   "+res.getString(5)+"   ");
            buffer.append(res.getInt(4));
            arl.add(buffer.toString());

            int toplam = DB.Gelir_Toplam(adi);
            gelirtoplami.setText(String.valueOf(toplam));
        }

        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, arl);

        gelirler_list.setAdapter(veriAdaptoru);

    }
}