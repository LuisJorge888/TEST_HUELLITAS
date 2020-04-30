package com.example.huellitas.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.huellitas.R;

public class test extends AppCompatActivity {

    private static final String SHARED_PREFS = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        SharedPreferences settings = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String value = settings.getString("id", "");
        String email = settings.getString("email", "");
        Toast.makeText(this, "Leo desde las PREF: id->"+value+" email->"+email, Toast.LENGTH_SHORT).show();

    }
}
