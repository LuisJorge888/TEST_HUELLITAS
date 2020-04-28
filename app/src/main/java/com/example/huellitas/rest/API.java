package com.example.huellitas.rest;

import com.example.huellitas.Configuracion;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
        private static <T> T builder(Class<T> endpoint) {
            return new Retrofit.Builder()
                    .baseUrl(Configuracion.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(endpoint);
        }

        public static HuellitasApiService movies() {
            return builder(HuellitasApiService.class);
        }
    }

