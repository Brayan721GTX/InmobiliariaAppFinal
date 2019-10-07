package com.example.inmobiliaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inmobiliaria.modelo.Propietario;
import com.example.inmobiliaria.modelo.PropietarioData;
import com.google.android.material.navigation.NavigationView;

public class Login extends AppCompatActivity {

    private EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.editText);
        etPassword = findViewById(R.id.editText2);
    }

    public void iniciarSesion(View view) {
        String mail = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        Propietario propietario = new PropietarioData().credencialesValidas(mail, password);

        if(propietario != null) {
            Intent intent = new Intent(this, Home.class);

            int idPropietario = 1;//Obtener el id del propietario que inicio sesion del modelo
            intent.putExtra("idPropietario", idPropietario);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Contraseña o mail incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}
