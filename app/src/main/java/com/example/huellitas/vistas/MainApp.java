package com.example.huellitas.vistas;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.huellitas.R;
import com.example.huellitas.vistas.ui.AltaMascota.AltaMascota;
import com.example.huellitas.vistas.ui.MisMascotas.MisMascotas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainApp extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private static final String SHARED_PREFS = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_AltaMascota, R.id.nav_VerMascota, R.id.nav_CerrarSession)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_app, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Esta_login();
    }

    public void Esta_login() {
        SharedPreferences settings = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        if (!settings.contains("login")) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        }
    }
    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.nav_home:

            case R.id.nav_AltaMascota:
                fragmentManager = getSupportFragmentManager();
                fragmentTransacion = fragmentManager.beginTransaction();
                fragmentTransacion.replace(R.id.panel, new AltaMascota());
                return true;
            case R.id.nav_VerMascota:
                fragmentManager = getSupportFragmentManager();
                fragmentTransacion = fragmentManager.beginTransaction();
                fragmentTransacion.replace(R.id.panel, new MisMascotas());
                return true;
            case R.id.nav_CerrarSession:
                Toast.makeText(MainApp.this, "Cerro Sesion", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */

}
