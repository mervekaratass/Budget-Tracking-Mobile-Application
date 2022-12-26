package com.example.butce_takip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.butce_takip.Database.Database_Yeni;

import java.util.ArrayList;

public class ana_sayfa extends AppCompatActivity {
    Button btn_gelir,btn_gider,btn_gelir_es,btn_gider_es;
    ArrayList<gelir_goruntule> gelirler;
    ListView gelirler_listesi;
    TextView ad;
    EditText gelirtoplami,gidertoplami,bakiye;
    Database_Yeni DB;
    int toplamgelir,toplamgider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);
        gelirler_listesi=findViewById(R.id.gider_list);
        DB = new Database_Yeni(this);

        btn_gelir=findViewById(R.id.btn_gelir_list);
        btn_gider=findViewById(R.id.btn_gider_list);
        btn_gelir_es=findViewById(R.id.btn_gelir_eklesil);
        btn_gider_es=findViewById(R.id.btn_gider_eklesil);
        gelirtoplami=findViewById(R.id.txtgelir_toplamlari);
        gidertoplami=findViewById(R.id.txtgider_toplamlari);
        bakiye=findViewById(R.id.txtbakiye);
        ad=findViewById(R.id.txtkulladi);



        btn_gelir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent4 = new Intent(getApplicationContext(), gelir_goruntule.class);
                   // intent4.putExtra("isim",ad.getText().toString());
                    startActivity(intent4);
            }
        });
        btn_gider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getApplicationContext(), gider_goruntule.class);
                //intent5.putExtra("isim",ad.getText().toString());
                startActivity(intent5);
            }
        });
        btn_gelir_es.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), gelir.class);
               // intent2.putExtra("isim",ad.getText().toString());
                startActivity(intent2);
            }
        });
        btn_gider_es.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), gider.class);
               //intent3.putExtra("isim",ad.getText().toString());
                startActivity(intent3);
            }
        });

       Intent intent=getIntent();
        String kullad="merve";
        ad.setText(kullad);
        if(kullad==null)
        {
            Intent intent2=getIntent();
            String kullad2="merve";
            ad.setText(kullad2);
            if(kullad2==null)
            {
                Intent intent4=getIntent();
                String kullad4="merve";
                ad.setText(kullad4);
                int toplam4 = DB.Gelir_Toplam(kullad4);
                gelirtoplami.setText(String.valueOf(toplam4)+" TL");
                int gidertoplam4 = DB.Gider_Toplam(kullad4);
                gidertoplami.setText(String.valueOf(gidertoplam4) +" TL");
                int bakiye_tl=toplam4-gidertoplam4;
                bakiye.setText(String.valueOf(bakiye_tl)+" ₺");

            }
            else
            {
                ad.setText(kullad2);
                int toplam2 = DB.Gelir_Toplam(kullad2);
                gelirtoplami.setText(String.valueOf(toplam2)+" TL");
                int gidertoplam2 = DB.Gider_Toplam(kullad2);
                gidertoplami.setText(String.valueOf(gidertoplam2) +" TL");
                int bakiye_tl=toplam2-gidertoplam2;
                bakiye.setText(String.valueOf(bakiye_tl)+" ₺");
            }
        }
        else
        {
            ad.setText(kullad);
            int toplam = DB.Gelir_Toplam(kullad);
            gelirtoplami.setText(String.valueOf(toplam)+" TL");
            int gidertoplam = DB.Gider_Toplam(kullad);
            gidertoplami.setText(String.valueOf(gidertoplam)+" TL");
            int bakiye_tl=toplam-gidertoplam;
            bakiye.setText(String.valueOf(bakiye_tl)+" ₺");

        }


    }
}