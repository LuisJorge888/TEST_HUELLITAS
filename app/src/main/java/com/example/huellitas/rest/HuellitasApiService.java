package com.example.huellitas.rest;

import com.example.huellitas.model.LoginResponse;
import com.example.huellitas.model.mascota;
import com.example.huellitas.model.mascotasResponse;
import com.example.huellitas.model.usuario;

import java.sql.Blob;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HuellitasApiService {

    @POST("add/pet")
    @FormUrlEncoded
    Call<mascota> crearMascota(
            @Field("nombre") String nombre,
            @Field("edad") int edad,
            @Field("genero") String genero,
            @Field("tipo") int tipo,
            @Field("raza") String razaMascota,
            @Field("descripcion") String descripcion,
            //@Field("fotomascota") Blob fotomascota,
            //@Field("dueniomascota") usuario dueniomascota
            @Field("duenio") int id
     );

    @POST("login")
    @FormUrlEncoded
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("clave") String clave
    );

    @POST("get/pet")
    @FormUrlEncoded
    Call<mascotasResponse> getMascotas(
            @Field("duenio") int id
    );


}
