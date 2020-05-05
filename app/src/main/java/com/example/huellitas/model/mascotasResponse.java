package com.example.huellitas.model;

import java.util.ArrayList;
import com.example.huellitas.model.mascota;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class mascotasResponse {
    @Expose
    @SerializedName("mascotas")
    private ArrayList<mascota> mascotas;

    public ArrayList<mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
