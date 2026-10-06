package com.lusia.zadaniejson;

import kotlin.jvm.internal.SerializedIr;
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

    public Artykul(int id, String tytul, String data, String tresc){
        this.id = id;
        this.tytul = tytul;
        this.data = data;
        this.tresc = tresc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }
}
