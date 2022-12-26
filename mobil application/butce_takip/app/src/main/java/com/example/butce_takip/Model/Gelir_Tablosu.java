package com.example.butce_takip.Model;

public class Gelir_Tablosu {
    private int gelir_id;
    private String kull_adi;
    private int tutar;
    private String gelir_turu;
    private String tarih;

    public Gelir_Tablosu(String gelir_turu, int tutar, String tarih) {
        this.gelir_turu = gelir_turu;
        this.tutar = tutar;
        this.tarih = tarih;
    }

    public Gelir_Tablosu(int id, String gelir_turu, int tutar, String tarih) {
        this.gelir_id=id;
        this.gelir_turu = gelir_turu;
        this.tutar = tutar;
        this.tarih = tarih;
    }

    public Gelir_Tablosu(int gelir_id) {
        this.gelir_id=gelir_id;
    }



    public int getGelir_id() {
        return gelir_id;
    }

    public void setGelir_id(int gelir_id) {
        this.gelir_id = gelir_id;
    }

    public String getKull_adi() {
        return kull_adi;
    }

    public void setKull_adi(String kull_adi) {
        this.kull_adi = kull_adi;
    }

    public double getTutar() {
        return tutar;
    }

    public void setTutar(int tutar) {
        this.tutar = tutar;
    }

    public String getGelir_turu() {
        return gelir_turu;
    }

    public void setGelir_turu(String gelir_turu) {
        this.gelir_turu = gelir_turu;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String toString()
    {
        return tarih+" "+gelir_turu+" "+tutar+" TL";
    }

}
