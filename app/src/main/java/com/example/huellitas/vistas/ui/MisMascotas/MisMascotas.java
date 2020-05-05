package com.example.huellitas.vistas.ui.MisMascotas;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.huellitas.R;
import com.example.huellitas.adapter.mascotasAdapter;
import com.example.huellitas.model.mascota;
import com.example.huellitas.model.mascotasResponse;
import com.example.huellitas.rest.API;
import com.example.huellitas.rest.HuellitasApiService;
import com.example.huellitas.utils.OnItemClickListener;
import com.example.huellitas.vistas.test;
import com.example.huellitas.vistas.ui.InfoMascota.InfoMascota;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class MisMascotas extends Fragment {

    RecyclerView recyclerViewMascotas;
    ArrayList<mascota> listaMascotas;
    HuellitasApiService huellitasApiService;
    private static final String SHARED_PREFS = "login";


    private MisMascotasViewModel mViewModel;

    public static MisMascotas newInstance() {
        return new MisMascotas();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mis_mascotas_fragment, container, false);
        recyclerViewMascotas = (RecyclerView) view.findViewById(R.id.rvMascotas);
        recyclerViewMascotas.setLayoutManager(new LinearLayoutManager(getActivity()));

        obtenerMascotas();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MisMascotasViewModel.class);
        // TODO: Use the ViewModel
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getContext(), "Lista mis mascotas", Toast.LENGTH_SHORT).show();

    }

    private void llenarRecyclerViewMascotas(ArrayList<mascota> mascotas) {
        mascotasAdapter adapter;
        adapter =new mascotasAdapter(mascotas, R.layout.list_item_mascotas, getActivity());
        recyclerViewMascotas.setAdapter(new mascotasAdapter(mascotas, R.layout.list_item_mascotas, getActivity()));
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(mascota item) {
                Toast.makeText(getContext(), item.getNombre(), Toast.LENGTH_LONG).show();
                InfoMascota info= new InfoMascota();
                /*
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(nextFrag)
                        .addToBackStack(null)
                        .commit();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.toolbar,nextFrag)
                        .addToBackStack(null)
                        .commit();
                */

                FragmentManager f = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = f.beginTransaction();
                ft.replace(R.id.nav_VerMascota, info, "tag");
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        recyclerViewMascotas.setAdapter(adapter);
    }

    private void obtenerMascotas() {

        final Activity activity = getActivity();
        SharedPreferences settings = activity.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final String idUsuarioxd = settings.getString("id", "");
        final int id = Integer.parseInt(idUsuarioxd);
        huellitasApiService = API.getAPI().create(HuellitasApiService.class);
        Call<mascotasResponse> call = huellitasApiService.getMascotas(id);

        call.enqueue(new Callback<mascotasResponse>() {
            @Override
            public void onResponse(Call<mascotasResponse> call, Response<mascotasResponse> response) {
            if(response.isSuccessful()){
                mascotasResponse mascotasResponse = response.body();
                llenarRecyclerViewMascotas(mascotasResponse.getMascotas());

            } else{
                Toast.makeText(activity, "Error en el formato de respuesta", Toast.LENGTH_SHORT).show();
            }
            }

            @Override
            public void onFailure(Call<mascotasResponse> call, Throwable t) {
            Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
}


}
