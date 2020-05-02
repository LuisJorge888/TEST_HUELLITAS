package com.example.huellitas.vistas.ui.MisMascotas;

import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.huellitas.R;

public class MisMascotas extends Fragment {

    private MisMascotasViewModel mViewModel;

    public static MisMascotas newInstance() {
        return new MisMascotas();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mis_mascotas_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MisMascotasViewModel.class);
        // TODO: Use the ViewModel
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity activity = getActivity();
        Toast.makeText(activity, "Lista mis mascotas", Toast.LENGTH_SHORT).show();
    }
}
