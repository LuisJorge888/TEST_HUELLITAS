package com.example.huellitas.vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.huellitas.R;
import com.example.huellitas.adapter.mascotasAdapter;


public class ListarMascotas extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_mascotas);

        recyclerView = (RecyclerView) findViewById(R.id.rvMascotas);
        recyclerView.setHasFixedSize(true);

        //layoutManager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //ndea
        //mAdapter = new mascotasAdapter(myDataSet);
        recyclerView.setAdapter(mAdapter);

        }
    }
