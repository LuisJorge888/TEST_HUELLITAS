package com.example.huellitas.vistas.ui.AltaMascota;

import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.huellitas.R;

public class AltaMascota extends Fragment {

    private AltaMascotaViewModel mViewModel;

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
        mViewModel = ViewModelProviders.of(this).get(AltaMascotaViewModel.class);
        // TODO: Use the ViewModel
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity activity = getActivity();
        Toast.makeText(activity, "Alta de Mascotas", Toast.LENGTH_SHORT).show();
    }

}
