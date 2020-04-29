package com.example.huellitas.vistas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.huellitas.R;
import com.example.huellitas.model.mascota;
import com.example.huellitas.rest.API;
import com.example.huellitas.rest.HuellitasApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class CrearMascota extends AppCompatActivity {

    EditText edtNombre, edtEdad, edtDescripcion;
    Spinner spnGenero, spnTipo;
    Button btnAgregarMascota;
    HuellitasApiService huellitasApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearmascota);
        edtNombre = (EditText) findViewById(R.id.nombre);
        edtEdad = (EditText) findViewById(R.id.edad);
        spnGenero = (Spinner) findViewById(R.id.genero);
        spnTipo = (Spinner) findViewById(R.id.tipomascota);
        edtDescripcion = (EditText) findViewById(R.id.descripcion);
        btnAgregarMascota = (Button) findViewById(R.id.btnCrearMascota);

        btnAgregarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtNombre.getText().toString();
                int edad = Integer.parseInt(edtEdad.getText().toString());
                String genero = spnGenero.getSelectedItem().toString();
                String tipo = spnTipo.getSelectedItem().toString();
                String descripcion = edtDescripcion.getText().toString();

                String macho = "Macho";
                if(genero.equals(macho)){
                    altaMascota(nombre,edad,true,tipo,descripcion);
                } else{
                    altaMascota(nombre,edad,false,tipo,descripcion);
                }
            }
        });

    }

    private void altaMascota(String nombre, int edad, boolean genero, String tipo, String descripcion){
        huellitasApiService = API.getAPI().create(HuellitasApiService.class);
        Call<mascota> call = huellitasApiService.crearMascota(nombre,edad, genero, tipo, descripcion);
        call.enqueue(new Callback<mascota>() {
            @Override
            public void onResponse(@NonNull Call<mascota> call, @NonNull Response<mascota> response) {
            if(response.isSuccessful()){
                Toast.makeText(CrearMascota.this, "la mascota se dio de alta", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(CrearMascota.this, "la mascota no se dio de alta", Toast.LENGTH_SHORT).show();
            }

            }

            @Override
            public void onFailure(@NonNull Call<mascota> call, @NonNull Throwable t) {
            Toast.makeText(CrearMascota.this, t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });



    }


}


