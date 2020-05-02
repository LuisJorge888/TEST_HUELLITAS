package com.example.huellitas.vistas.ui.AltaMascota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.huellitas.R;
import com.example.huellitas.model.mascota;
import com.example.huellitas.rest.API;
import com.example.huellitas.rest.HuellitasApiService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class AltaMascota extends Fragment {

    private AltaMascotaViewModel mViewModel;
    EditText edtNombre, edtEdad, edtDescripcion;
    Spinner spnGenero, spnTipo, spnRaza;
    Button btnAgregarMascota;
    HuellitasApiService huellitasApiService;
    String[] strRazaPerro, strRazaGato;
    List<String> listaRazaPerro, listaRazaGato;
    ArrayAdapter<String> razaAdapterPerro, razaAdapterGato;


    private static Retrofit retrofit = null;
    private static final String SHARED_PREFS = "login";


    public static AltaMascota newInstance() {
        return new AltaMascota();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.alta_mascota_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(AltaMascotaViewModel.class);
        // TODO: Use the ViewModel

        //Convierto la variable List<> en un ArrayList<>()
        listaRazaPerro = new ArrayList<>();
        listaRazaGato = new ArrayList<>();
        //Arreglo con nombre de razas
        strRazaPerro = new String[] {"Pastor alemán", "Bulldog", "Poodle", "Labrador retriever", "Golden retriever"};
        strRazaGato = new String[] {"Gato persa", "Bengala", "Maine Coon", "Siamés", "Sphynx"};
        //Agrego las razas del arreglo `strRazaPerro` a la listaRazaPerro
        Collections.addAll(listaRazaPerro, strRazaPerro);
        Collections.addAll(listaRazaGato, strRazaGato);
        razaAdapterPerro = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, listaRazaPerro);
        razaAdapterGato = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, listaRazaGato);


        final Activity activity = getActivity();
        SharedPreferences settings = activity.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final String idUsuarioxd = settings.getString("id", "");
        final int id = Integer.parseInt(idUsuarioxd);
        edtNombre = (EditText) getView().findViewById(R.id.nombre);
        edtEdad = (EditText) getView().findViewById(R.id.edad);
        spnGenero = (Spinner) getView().findViewById(R.id.genero);
        spnTipo = (Spinner) getView().findViewById(R.id.tipomascota);
        spnRaza = (Spinner) getView().findViewById(R.id.razaMascota);
        edtDescripcion = (EditText) getView().findViewById(R.id.descripcion);
        btnAgregarMascota = (Button) getView().findViewById(R.id.btnCrearMascota);

        spnTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Sirve para obtener el valor del spinner
                String tipoMascota = spnTipo.getItemAtPosition(position).toString();

                if(tipoMascota.equals("Perro")){
                    spnRaza.setAdapter(razaAdapterPerro);
                }   else if(tipoMascota.equals("Gato")){
                    spnRaza.setAdapter(razaAdapterGato);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnAgregarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtNombre.getText().toString();
                int edad = Integer.parseInt(edtEdad.getText().toString());
                String genero = spnGenero.getSelectedItem().toString();
                String tipo = spnTipo.getSelectedItem().toString();
                String descripcion = edtDescripcion.getText().toString();
                String razaMascota = spnRaza.getSelectedItem().toString();

                int tipoMascota;
                if(tipo.equals("Gato")){
                    tipoMascota = 2;
                } else if(tipo.equals("Perro")){
                    tipoMascota = 1;
                } else {
                    tipoMascota = 3;
                }

                    altaMascota(nombre, edad, genero, tipoMascota, razaMascota, descripcion, id);

            }
        });

    }

  /*  public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity activity = getActivity();
        Toast.makeText(activity, "Alta de Mascotas", Toast.LENGTH_SHORT).show();
    }

   */

    private void altaMascota(String nombre, int edad, String genero, int tipo, String razaMascota , String descripcion, int id) {
        huellitasApiService = API.getAPI().create(HuellitasApiService.class);
        //huellitasApiService = retrofit.create(HuellitasApiService.class);
        Call<mascota> call = huellitasApiService.crearMascota(nombre, edad, genero, tipo, razaMascota, descripcion, id);

        call.enqueue(new Callback<mascota>() {
            @Override
            public void onResponse(@NonNull Call<mascota> call, @NonNull Response<mascota> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getActivity(), "la mascota se dio de alta", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "la mascota no se dio de alta", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<mascota> call, @NonNull Throwable t) {
                Toast.makeText(getActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}
