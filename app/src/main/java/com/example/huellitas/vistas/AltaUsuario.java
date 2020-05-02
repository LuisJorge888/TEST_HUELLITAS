package com.example.huellitas.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.huellitas.R;

import java.util.regex.Pattern;

public class AltaUsuario extends AppCompatActivity {
    private static final int SELECT_FILE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_usuario);
        this.setTitle("Registro");
    }

    public void regresarMenu(View vista){
        Intent itent = new Intent(this,MainActivity.class);
        startActivity(itent);
    }

    public void abrirGaleria(View Vixta){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Selecciona una imagen"),SELECT_FILE);
    }

    public void validarInputs(View Vistazo){
        //Crear las variables
        String nombre,apellido,direccion,telefono1="N/A",telefono2="N/A",correo,password,repasword;
        ImageView fotoPerfil;
        //Obtener las cajitas de texto
        EditText editNombre=(EditText)findViewById(R.id.editText6);
        EditText editApellido=(EditText)findViewById(R.id.editText7);
        EditText editDireccion=(EditText)findViewById(R.id.editText9);
        EditText editCorreo=(EditText)findViewById(R.id.editText);
        EditText editPassword=(EditText)findViewById(R.id.editText10);
        EditText editRePasword=(EditText)findViewById(R.id.editText12);
        EditText editTelefono1=(EditText)findViewById(R.id.editText5);
        EditText editTelefono2=(EditText)findViewById(R.id.editText11);

        //Pasar los datos a strings
        nombre=editNombre.getText().toString();
        apellido=editApellido.getText().toString();
        direccion=editDireccion.getText().toString();
        telefono1=editTelefono1.getText().toString();
        telefono2=editTelefono2.getText().toString();
        correo=editCorreo.getText().toString();
        password=editPassword.getText().toString();
        repasword=editRePasword.getText().toString();

        //Patron para determinar la validez de un correo electronico
        Pattern patronMail = Patterns.EMAIL_ADDRESS;

        //Verificar datos
        if(nombre.isEmpty()||nombre.length()<=0)
            Toast.makeText(this,"El campo 'nombre' no puede estar vacio!",Toast.LENGTH_LONG).show();
        else if(apellido.isEmpty()||apellido.length()<=0)
            Toast.makeText(this,"El campo 'apellido' no puede estar vacio!",Toast.LENGTH_LONG).show();
        else if(correo.isEmpty()||correo.length()<=0)
            Toast.makeText(this,"Ingresa al menos un correo!",Toast.LENGTH_LONG).show();
        else if(!(patronMail.matcher(correo).matches()))
            Toast.makeText(this,"Correo ingresado invalido!",Toast.LENGTH_LONG).show();
        else if(direccion.isEmpty()||direccion.length()<=0)
            Toast.makeText(this,"El campo 'dirección' no puede estar vacio!",Toast.LENGTH_LONG).show();
        else if(password.isEmpty()||password.length()<=0)
            Toast.makeText(this,"Ingresa una contraseña!",Toast.LENGTH_LONG).show();
        else if(repasword.isEmpty()||repasword.length()<=0)
            Toast.makeText(this,"Ingresa nuevamente la contraseña!",Toast.LENGTH_LONG).show();
        else if(!(password.equals(repasword)))
            Toast.makeText(this,"Las contraseñas no coinciden!",Toast.LENGTH_LONG).show();
        else{
            Intent itent = new Intent(this,MainActivity.class);
            //Enviar datos a la main activity

            itent.putExtra("REGISTRO",1);
            itent.putExtra("Nombre",nombre);
            itent.putExtra("Correo",correo);
            startActivity(itent);
            //Toast.makeText(this,"LA PUTA MADRE!",Toast.LENGTH_LONG).show();
        }
    }
}
