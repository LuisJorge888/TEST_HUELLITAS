package com.example.huellitas.vistas.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.huellitas.R;
import com.example.huellitas.vistas.ui.ui.altamascota.AltaMascotaFragment;

public class AltaMascota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alta_mascota_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, AltaMascotaFragment.newInstance())
                    .commitNow();
        }
    }
}
