package com.example.inmobiliaria.modelo;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static Connection connection;
    private static String ip = "192.168.1.102";
    private static String port = "1433";
    private static String classs = "net.sourceforge.jtds.jdbc.Driver";
    private static String db = "inmobiliaria";
    private static String un = "sa";
    private static String password = "admin";

    private Conexion() {
    }

    public static Connection getConexion () throws Exception {
        if (connection == null) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Class.forName(classs).newInstance();
            //connection = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.102;databaseName=inmobiliaria;user=;password=");

            String ConnURL = "jdbc:jtds:sqlserver://" + ip +":"+port+";"
                    + "databaseName=" + db + ";user=" + un + ";password="
                    + password + ";";
            connection = DriverManager.getConnection(ConnURL);
        }

        return connection;
    }
}
