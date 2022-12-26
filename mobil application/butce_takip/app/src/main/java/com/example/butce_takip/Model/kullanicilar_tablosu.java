package com.example.butce_takip.Model;

public class kullanicilar_tablosu {
    String Kullanici_adi;
    String sifre;

    public kullanicilar_tablosu(String kullad, String sifre) {
        this.Kullanici_adi = kullad;
        this.sifre = sifre;
    }

    public String getKullanici_adi() {
        return Kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        Kullanici_adi = kullanici_adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }


}
