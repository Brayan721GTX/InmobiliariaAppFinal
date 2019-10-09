package com.example.inmobiliaria;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.example.inmobiliaria.modelo.Conexion;

import java.sql.Connection;

import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.READ_CONTACTS;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Conexion conexion = new Conexion();

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    /*private void probarConexion() {
        try {
            Connection connection = Conexion.getConexion();
            Toast.makeText(this, "Conectado", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("HOLA", "EXCEPCION: "+e.getMessage());
            Toast.makeText(this, "No conectado: "+e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }*/
}
