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

        //validaPermisos();
        //probarConexion();
        //Toast.makeText(this, "Conexion exitosa", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    private void probarConexion() {
        try {
            Connection connection = Conexion.getConexion();
            Toast.makeText(this, "BIEN", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("HOLA", "EXCEPCION: "+e.getMessage());
        }
    }

    private boolean validaPermisos() {
        //Toast.makeText(this, "NOOOOOOOOOOOO", Toast.LENGTH_SHORT).show();

        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            Toast.makeText(this, "ANDAAAAAAAAAAAAA", Toast.LENGTH_SHORT).show();
            return true;
        }
        //Toast.makeText(this, "PASO ACA ", Toast.LENGTH_SHORT).show();

        if((checkSelfPermission(INTERNET)== PackageManager.PERMISSION_GRANTED)){
            Toast.makeText(this, "La aplicacion tiene los permisos necesarios", Toast.LENGTH_SHORT).show();
            return true;
        }

        if((shouldShowRequestPermissionRationale(INTERNET))){
            cargarDialogoRecomendacion();
        }else{
            requestPermissions(new String[]{INTERNET},100);
        }

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100){
            if(grantResults.length==2 && grantResults[0]==PackageManager.PERMISSION_GRANTED
                    && grantResults[1]== PackageManager.PERMISSION_GRANTED){
                //acceder();
                probarConexion();
            }else{
                solicitarPermisosManual();
            }
        }

    }

    private void solicitarPermisosManual() {
        final CharSequence[] opciones={"si","no"};
        final AlertDialog.Builder alertOpciones=new AlertDialog.Builder(MainActivity.this);
        alertOpciones.setTitle("¿Desea configurar los permisos de forma manual?");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("si")){
                    Intent intent=new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri=Uri.fromParts("package",getPackageName(),null);
                    intent.setData(uri);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Los permisos no fueron aceptados",Toast.LENGTH_SHORT).show();
                    dialogInterface.dismiss();
                }
            }
        });
        alertOpciones.show();
    }

    private void cargarDialogoRecomendacion() {
        AlertDialog.Builder dialogo=new AlertDialog.Builder(MainActivity.this);
        dialogo.setTitle("Permisos Desactivados");
        dialogo.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");

        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                requestPermissions(new String[]{INTERNET},100);
            }
        });
        dialogo.show();
    }
}
