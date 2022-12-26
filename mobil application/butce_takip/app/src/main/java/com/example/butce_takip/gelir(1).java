package com.example.butce_takip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.butce_takip.Database.Database_Yeni;

public class gelir extends AppCompatActivity {

    EditText tur,tarih,tutar,id;
    Button ekle,sil;
//    ,anasayfa;
    TextView ad;
    Database_Yeni DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelir);

        DB = new Database_Yeni(this);

        ekle=findViewById(R.id.gelir_ekle);
        sil=findViewById(R.id.gelir_sil);



        id=findViewById(R.id.edtgelirid);
        tutar=findViewById(R.id.edtgelir_tutar);
        tur=findViewById(R.id.edtgelir_turu);
        tarih=findViewById(R.id.edttarih);


        /*Intent intent2=getIntent();
        String kullad2=intent2.getStringExtra("isim");
        kullanici_adi.setText(kullad2);*/



/*
        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                intent2.putExtra("isim2",kullanici_adi.getText().toString());
                startActivity(intent2);
            }
        });*/

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sifre="0";
                String kullaniciad="merve";
                String islem_turu="Gelir";
                String aciklama=tur.getText().toString();
                String gelirtarih=tarih.getText().toString();
                // String gelirid=id.getText().toString();
                int gelir_tutar_int=Integer.parseInt(tutar.getText().toString());

                String deneme = DB.son_id();
                int idd=(Integer.parseInt(deneme))+1;
                String son_id_str=String.valueOf(idd);

                Boolean checkdata = DB.insertdata(son_id_str,kullaniciad, sifre,islem_turu,gelir_tutar_int,aciklama, gelirtarih);
                if(checkdata==true)
                    Toast.makeText(gelir.this, "Kayıt eklendi.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(gelir.this, "Kaydınız eklenemedi.", Toast.LENGTH_SHORT).show();

            }
        });

        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gelirid=id.getText().toString();

                Boolean checkdata = DB.deletedata(gelirid);
                if(checkdata==true)
                    Toast.makeText(gelir.this, "Gelir kaydınız silinmiştir.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(gelir.this, "Kaydınızın numarasını kontrol ediniz!", Toast.LENGTH_SHORT).show();

            }
        });


    }
}