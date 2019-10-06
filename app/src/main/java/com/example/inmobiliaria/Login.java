package com.example.inmobiliaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.inmobiliaria.modelo.Propietario;
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
        if(true) {
            Intent intent = new Intent(this, Home.class);

            int idPropietario = 1;//Obtener el id del propietario que inicio sesion del modelo
            intent.putExtra("idPropietario", idPropietario);
            startActivity(intent);
        }
    }
}
