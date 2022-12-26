package com.example.butce_takip;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.butce_takip.R;
import androidx.appcompat.app.AppCompatActivity;

import com.example.butce_takip.Database.Database_Yeni;


public class MainActivity extends AppCompatActivity {

    Button giris;
    Button kayit;

    EditText  etUser;
    EditText etPass;


    Database_Yeni DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB = new Database_Yeni(this);

        giris=findViewById(R.id.girisyap);
        kayit=findViewById(R.id.kaydol);

        etUser=findViewById(R.id.etUser);
        etPass =findViewById(R.id.etPass);

        Intent intent=getIntent();
        String kullad=intent.getStringExtra("isim");



        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kullinput = etUser.getText().toString();
                String sifre = etPass.getText().toString();

                Boolean checkdata = DB.Giris_Kontrol(kullinput, sifre);
                if(checkdata==true)
                {
                    Toast.makeText(MainActivity.this, "Hoşgeldin "+etUser.getText().toString(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), ana_sayfa.class);
                    intent.putExtra("isim",etUser.getText().toString());
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "Bilgilerinizi kontrol ediniz.", Toast.LENGTH_SHORT).show();

            }
        });
        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sifre=etPass.getText().toString();
                String kullaniciad=etUser.getText().toString();
                String islem_turu="0";
                String aciklama="0";
                String gelirtarih="0";
                //  String gelirid="0";
                int gelir_tutar_int=0;

                String deneme = DB.son_id();
                int idd=(Integer.parseInt(deneme))+1;
                String son_id_str=String.valueOf(idd);


                Boolean checkdata = DB.insertdata(son_id_str,kullaniciad, sifre,islem_turu,gelir_tutar_int,aciklama, gelirtarih);
                if(checkdata==true)
                    Toast.makeText(MainActivity.this, "Kullanıcı kaydınız oluşturuldu.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Kaydınız oluşturulamadı. Tekrar deneyiniz.", Toast.LENGTH_SHORT).show();

            }
        });




    }
    public boolean emptyValidation() {
        if (TextUtils.isEmpty(etUser.getText().toString()) || TextUtils.isEmpty(etPass.getText().toString())) {
            return true;
        }else {
            return false;
        }
    }

}