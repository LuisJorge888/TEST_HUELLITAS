package com.example.huellitas.vistas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.huellitas.R;
import com.example.huellitas.model.LoginResponse;
import com.example.huellitas.rest.API;
import com.example.huellitas.rest.HuellitasApiService;

public class Login extends AppCompatActivity {

    private static final String SHARED_PREFS = "login";
    HuellitasApiService huellitasApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Esta_login();
        Button  login  = findViewById(R.id.btn_login);
        Button  registrar  = findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txt_email  = findViewById(R.id.txt_email);
                EditText txt_clave  = findViewById(R.id.txt_clave);
                CheckLogin(txt_email.getText().toString(),txt_clave.getText().toString());
            }
        });

    }

    public void CheckLogin(String mail, String clave){
        huellitasApiService = API.getAPI().create(HuellitasApiService.class);
        Call<LoginResponse> call = huellitasApiService.login(mail,clave);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                if(response.isSuccessful()){

                    if(response.body().getCode().equals("1")){  // email incorrecta
                        Toast.makeText(Login.this, "Email incorrecto", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(response.body().getCode().equals("2")){  // clave incorrecta
                        Toast.makeText(Login.this, "Clave incorrecta", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(response.body().getCode().equals("3")){  // todo OK
                        String mensaje = "Login: "+response.body().getId()+" "+response.body().getEmail();
                        String id = response.body().getId();
                        String email = response.body().getEmail();
                        Toast.makeText(Login.this, mensaje, Toast.LENGTH_SHORT).show();
                        Save_user(id,email);
                        Intent intent = new Intent(getApplicationContext(), MainApp.class);
                        startActivity(intent);
                    }
                } else{
                    Toast.makeText(Login.this, "Error: El serve no respondio", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                Toast.makeText(Login.this, t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void Save_user(String id, String email){
        SharedPreferences log = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor mylog = log.edit();
        mylog.putString("id",id);
        mylog.putString("email",email);
        mylog.putString("login", "true");
        mylog.commit();
    }

    public void Esta_login(){
        SharedPreferences settings = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        if(settings.contains("login")){
            String value = settings.getString("login","");
            if(value.equals("true")){
                Intent intent = new Intent(getApplicationContext(), MainApp.class);
                startActivity(intent);
            }else{
                Toast.makeText(Login.this, "Login es:"+value, Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(Login.this, "Nunca inicio sesion", Toast.LENGTH_SHORT).show();
        }
    }
}
