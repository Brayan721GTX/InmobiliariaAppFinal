package com.example.inmobiliaria.modelo;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public Conexion() {
    }

    public static Connection getConexion () throws Exception {
        Connection connection = null;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:jtds:sqlserver://10.0.2.2;databaseName=inmobiliaria;user=;password=");

        return connection;
    }
}
