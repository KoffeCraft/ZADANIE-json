package com.lusia.zadaniejson;

import com.google.gson.annotations.SerializedName;

public class Artykul {

    @SerializedName("id")
    private int id;

    @SerializedName("tytul")
    private String tytul;

    @SerializedName("data")
    private String data;

    @SerializedName("tresc")
    private String tresc;

    @SerializedName("kolorTytulu")
    private String kolorTytulu = "#800938";

    @SerializedName("rozmiarTytulu")
    private float rozmiarTytulu = 24;

    @SerializedName("kolorDaty")
    private String kolorDaty = "#757575";

    @SerializedName("rozmiarDaty")
    private float rozmiarDaty = 12;

    @SerializedName("kolorTresci")
    private String kolorTresci = "#212121";

    @SerializedName("rozmiarTresci")
    private float rozmiarTresci = 16;

    public Artykul() {
    }

    public int getId() {
        return id;
    }

    public String getTytul() {
        return tytul;
    }

    public String getData() {
        return data;
    }

    public String getTresc() {
        return tresc;
    }

    public String getKolorTytulu() {
        return kolorTytulu;
    }

    public float getRozmiarTytulu() {
        return rozmiarTytulu;
    }

    public String getKolorDaty() {
        return kolorDaty;
    }

    public float getRozmiarDaty() {
        return rozmiarDaty;
    }

    public String getKolorTresci() {
        return kolorTresci;
    }

    public float getRozmiarTresci() {
        return rozmiarTresci;
    }

    @Override
    public String toString() {
        return tytul + "\n" + data + "\n" + tresc;
    }
}