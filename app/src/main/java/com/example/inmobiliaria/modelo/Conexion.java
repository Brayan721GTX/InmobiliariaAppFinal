package com.example.inmobiliaria.modelo;

import android.os.StrictMode;

import net.sourceforge.jtds.jdbc.DateTime;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Conexion {

    /*private static Connection connection;
    private static String ip = "192.168.1.102";
    private static String port = "1433";
    private static String classs = "net.sourceforge.jtds.jdbc.Driver";
    private static String db = "inmobiliaria";
    private static String un = "sa";
    private static String password = "admin";
    */

    public static ArrayList<Propietario> propietarios = new ArrayList<Propietario>();
    public static ArrayList<Propiedad> propiedades = new ArrayList<Propiedad>();
    public static ArrayList<Inquilino> inquilinos = new ArrayList<Inquilino>();
    public static ArrayList<Alquiler> alquileres = new ArrayList<Alquiler>();
    public static ArrayList<Pago> pagos = new ArrayList<Pago>();

    public Conexion() {
        Propietario p1 = new Propietario(1, "20345287", "Gutierrez", "Tomas", "2664635241", "tomas@gmail.com", "tomas");
        Propietario p2 = new Propietario(2, "24847362", "Gatica", "Luciana", "2664546573", "luciana@gmail.com", "luciana");
        Propietario p3 = new Propietario(3, "35359346", "Bustos", "Ricardo", "2664068223", "ricardo@gmail.com", "ricardo");

        Conexion.propietarios.add(p1); Conexion.propietarios.add(p2); Conexion.propietarios.add(p3);

        Propiedad pro1 = new Propiedad(1, "San Luis capital b 134 c12", 4, "Departamento", "Residencial", 15000, false, p1);
        Propiedad pro2 = new Propiedad(2, "La Punta plaza de los niños lic 19 c5", 2, "Local", "Comercial", 18000, false, p1);
        Propiedad pro3 = new Propiedad(3, "La toma b 104 c 28", 4, "Departamento", "Residencial", 15000, true, p1);

        Propiedad pro4 = new Propiedad(4, "San Luis av Lafinur altura 1050", 3, "Departamento", "Residencial", 12000, false, p2);
        Propiedad pro5 = new Propiedad(5, "Juana Koslay b 16 c 31", 1, "Deposito", "Comercial", 9000, true, p2);
        Propiedad pro6 = new Propiedad(6, "Potrero de los Funes 140", 4, "Casa", "Residencial", 19000, true, p3);

        Conexion.propiedades.add(pro1); Conexion.propiedades.add(pro2); Conexion.propiedades.add(pro3);
        Conexion.propiedades.add(pro4); Conexion.propiedades.add(pro5); Conexion.propiedades.add(pro6);

        Inquilino i1 = new Inquilino(1, "40125957", "Rita", "Perez", "San Luis", "2664356457");
        Inquilino i2 = new Inquilino(2, "39456095", "Francisco", "Paez", "San Luis", "2664001192");
        Inquilino i3 = new Inquilino(3, "37837849", "Carlos", "Quevedo", "San Luis", "2664827038");

        Conexion.inquilinos.add(i1); Conexion.inquilinos.add(i2); Conexion.inquilinos.add(i3);

        Alquiler a1 = new Alquiler(1, 15000, "07/08/2019", "08/06/2020", i1, pro3);
        Alquiler a2 = new Alquiler(2, 9000, "05/09/2019", "05/01/2020", i2, pro5);
        Alquiler a3 = new Alquiler(3, 19000, "15/10/2019", "08/02/2020", i3, pro6);

        Conexion.alquileres.add(a1); Conexion.alquileres.add(a2); Conexion.alquileres.add(a3);

        Pago pago1 = new Pago(1, 1, "07/08/2019", 15000, a1);
        Pago pago2 = new Pago(2, 1, "05/09/2019", 9000, a2);
        Pago pago3 = new Pago(3, 2, "07/09/2019", 15000, a1);
        Pago pago4 = new Pago(4, 2, "05/10/2019", 9000, a2);
        Pago pago5 = new Pago(5, 3, "07/10/2019", 15000, a1);
        Pago pago6 = new Pago(6, 1, "15/10/2019", 19000, a3);

        Conexion.pagos.add(pago1); Conexion.pagos.add(pago2); Conexion.pagos.add(pago3);
        Conexion.pagos.add(pago4); Conexion.pagos.add(pago5); Conexion.pagos.add(pago6);

    }

/*public static Connection getConexion () throws Exception {
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
    }*/
}
