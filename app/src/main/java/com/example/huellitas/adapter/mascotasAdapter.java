package com.example.huellitas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huellitas.R;
import com.example.huellitas.model.mascota;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class mascotasAdapter extends RecyclerView.Adapter<mascotasAdapter.mascotasViewHolder> {
    private ArrayList<mascota> mascotas;
    private int rowLayout;
    private Context context;

    public mascotasAdapter(ArrayList<mascota> mascotas, int rowLayout, Context context){
        this.mascotas = mascotas;
        this.rowLayout = rowLayout;
        this.context = context;
    }


    public static class mascotasViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mascotasLayout;
        TextView nombreMascota;
        TextView idMascota;
        ImageView imagenMascota;

        public mascotasViewHolder(View v) {
            super(v);
            mascotasLayout =(LinearLayout) v.findViewById(R.id.mascotas_layout);
            //imagenMascota = (ImageView) v.findViewById(R.id.mascotas_image);
            nombreMascota = (TextView) v.findViewById(R.id.nombreMascota);
            idMascota = (TextView) v.findViewById(R.id.idMascota);
        }
    }

    @Override
    public mascotasAdapter.mascotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new mascotasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(mascotasViewHolder holder, final int position){
   /* String image_url = mascotas.get(position).getImagen();
    Picasso.with(context)
            .load(image_url)
            .placeholder(android.R.drawable.sym_def_app_icon)
            .error(android.R.drawable.sym_def_app_icon)
            .into(holder.imagenMascota); */
    holder.nombreMascota.setText(mascotas.get(position).getNombre());
    holder.idMascota.setText(String.valueOf(mascotas.get(position).getId()));
    }

    @Override
    public int getItemCount(){
        return mascotas.size();
    }
}
