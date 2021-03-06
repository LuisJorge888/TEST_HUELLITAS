package com.example.huellitas.rest;

import com.example.huellitas.Configuracion;

//import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    /*private static <T> T builder(Class<T> endpoint) {
        return new Retrofit.Builder()
                .baseUrl(Configuracion.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(endpoint);
    }

    public static HuellitasApiService huellitas() {
        return builder(HuellitasApiService.class);
    }
    */

      private static final String BASE_URL = "http://192.168.1.42/slim3/public/";

      private static Retrofit retrofit;

      public static Retrofit getAPI(){
          if(retrofit == null){
              retrofit = new Retrofit.Builder()
                      .baseUrl(BASE_URL)
                      .addConverterFactory(GsonConverterFactory.create())
                      .build();

          }
          return retrofit;
      }
}

