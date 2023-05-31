package com.example.scratch;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "anunt_table")
public class Anunt {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id_anunt;

    @NonNull
    @ColumnInfo(name="description")
    private String descriere;

    @NonNull
    @ColumnInfo(name ="pret")
    private Float pret;


    @ColumnInfo(name ="picture")
    private String link_poza;

    public Anunt(@NonNull String descriere, @NonNull Float pret) {
        this.descriere = descriere;
        this.pret = pret;
    }

    public Anunt(Anunt anunt) {
        this.descriere = anunt.descriere;
        this.pret = anunt.pret;
    }

    public int getId_anunt() {
        return id_anunt;
    }

    public void setId_anunt(int id_anunt) {
        this.id_anunt = id_anunt;
    }

    @NonNull
    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(@NonNull String descriere) {
        this.descriere = descriere;
    }

    @NonNull
    public Float getPret() {
        return pret;
    }

    public void setPret(@NonNull Float pret) {
        this.pret = pret;
    }

    public String getLink_poza() {
        return link_poza;
    }

    public void setLink_poza(String link_poza) {
        this.link_poza = link_poza;
    }
}

