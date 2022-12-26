package com.example.butce_takip.Model;

public class Gider_Tablosu {

    private int gider_id;
    private String kull_adi;
    private double tutar;
    private String gider_turu;
    private String tarih;

    public Gider_Tablosu(String gider_turu, int tutar, String tarih) {

        this.gider_turu = gider_turu;
        this.tutar = tutar;
        this.tarih = tarih;
    }

    public Gider_Tablosu(int id, String gider_turu, int gider_tutar_int, String tarih) {
        this.gider_id = id;
        this.gider_turu = gider_turu;
        this.tutar = gider_tutar_int;
        this.tarih = tarih;
    }
    public Gider_Tablosu(int id) {
        this.gider_id = id;
    }

    public int getGider_id() {
        return gider_id;
    }

    public void setGider_id(int gider_id) {
        this.gider_id = gider_id;
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

    public void setTutar(double tutar) {
        this.tutar = tutar;
    }

    public String getGider_turu() {
        return gider_turu;
    }

    public void setGider_turu(String gider_turu) {
        this.gider_turu = gider_turu;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
}
