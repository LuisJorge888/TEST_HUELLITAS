package com.example.huellitas.rest;

import com.example.huellitas.model.mascota;
import com.example.huellitas.model.usuario;

import java.sql.Blob;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HuellitasApiService {

    @POST("add/pet")
    @FormUrlEncoded
    Call<mascota> crearMascota(
            @Field("nombre") String nombre,
            @Field("edad") int edad,
            @Field("genero") boolean genero,
            @Field("tipo") String tipo,
            //@Field("raza") String raza,
            @Field("descripcion") String descripcion
            //@Field("fotomascota") Blob fotomascota,
            //@Field("dueniomascota") usuario dueniomascota
     );

}
