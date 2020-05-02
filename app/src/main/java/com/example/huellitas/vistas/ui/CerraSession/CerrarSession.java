package com.example.huellitas.vistas.ui.CerraSession;

import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.huellitas.R;
import com.example.huellitas.vistas.Login;
import com.example.huellitas.vistas.MainApp;

import static android.content.Context.MODE_PRIVATE;

public class CerrarSession extends Fragment {

    private CerrarSessionViewModel mViewModel;
    private static final String SHARED_PREFS = "login";

    public static CerrarSession newInstance() {
        return new CerrarSession();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cerrar_session_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CerrarSessionViewModel.class);
        // TODO: Use the ViewModel
        final Activity activity = getActivity();
        Toast.makeText(activity, "Cerrar sesion", Toast.LENGTH_SHORT).show();
        Button login  = getView().findViewById(R.id.btn_CerraSession);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SharedPreferences pref = activity.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences settings = activity.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                editor.remove("id");
                editor.remove("email");
                editor.remove("login");
                editor.apply();
                editor.clear();
                editor.commit();
               // try {
               //     Thread.sleep(2000);
                    Intent intent = new Intent(activity, Login.class);
                    startActivity(intent);
               // } catch (InterruptedException e) {
                //    e.printStackTrace();
                  //  Toast.makeText(activity, "Error: Algo salio mal al cerrar session", Toast.LENGTH_SHORT).show();
                //}


                //SharedPreferences settings = activity.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                //String value = settings.getString("id", "");
                //String email = settings.getString("email", "");
                //Toast.makeText(activity, "Leo desde las PREF: id->"+value+" email->"+email, Toast.LENGTH_SHORT).show();

            }
        });
    }
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Activity activity = getActivity();
        Toast.makeText(activity, "Cerrar sesion", Toast.LENGTH_SHORT).show();
        Button login  = getView().findViewById(R.id.btn_CerraSession);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = activity.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.remove("id");
                editor.remove("email");
                editor.remove("login");
                editor.apply();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(activity, MainApp.class);
                startActivity(intent);
            }
        });
    }
    */
}
