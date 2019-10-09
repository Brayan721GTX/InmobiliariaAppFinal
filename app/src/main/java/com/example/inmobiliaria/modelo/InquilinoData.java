package com.example.inmobiliaria.modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class InquilinoData {

    public ArrayList<Inquilino> obtenerInquilinos() {
        return Conexion.inquilinos;
    }

    public Inquilino obtenerInquilino(int id) {
        for (Inquilino i : Conexion.inquilinos) {
            if (i.getId() == id) {
                return i;
            }
        }

        return null;
    }

    public ArrayList<Inquilino> obtenerInquilinosDePropiedad(int idPropiedad) {
        ArrayList<Inquilino> inquilinos = new ArrayList<Inquilino>();

        ArrayList<Alquiler> alquileresDePropiedad = new AlquilerData().obtenerContratosDePropiedad(idPropiedad);

        for (Inquilino i : Conexion.inquilinos) {
            for (Alquiler a: alquileresDePropiedad) {
                if (a.getInquilino().getId() == i.getId()) {
                    inquilinos.add(i);
                    break;
                }
            }
        }

        return inquilinos;
    }

    /*public ArrayList<Inquilino> obtenerInquilinos() {
        try {
            Statement statement = Conexion.getConexion().createStatement();

            String sql = "SELECT * FROM inqulino";

            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<Inquilino> inquilinos = new ArrayList<Inquilino>();

            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                String dni = resultSet.getString("dni");
                String apellido = resultSet.getString("apellido");
                String nombre = resultSet.getString("nombre");
                String telefono = resultSet.getString("telefono");
                String direccion = resultSet.getString("direccion");

                Inquilino inquilino = new Inquilino(id, dni, nombre, apellido, direccion, telefono);

                inquilinos.add(inquilino);
            }

            return inquilinos;
        }
        catch (Exception e) {
        }

        return null;
    }

    public Inquilino obtenerInquilino(int id) {
        try {
            Statement statement = Conexion.getConexion().createStatement();

            String sql = "SELECT * FROM inqulino WHERE id = "+id;

            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()) {
                String dni = resultSet.getString("dni");
                String apellido = resultSet.getString("apellido");
                String nombre = resultSet.getString("nombre");
                String telefono = resultSet.getString("telefono");
                String direccion = resultSet.getString("direccion");

                Inquilino inquilino = new Inquilino(id, dni, nombre, apellido, direccion, telefono);

                return inquilino;
            }
        }
        catch (Exception e) {
        }

        return null;
    }

    public ArrayList<Inquilino> obtenerInquilinosDePropiedad(int idPropiedad) {
        ArrayList<Alquiler> alquileres = new AlquilerData().obtenerContratosDePropiedad(idPropiedad);

        ArrayList<Inquilino> inquilinos = new ArrayList<Inquilino>();

        for (Alquiler a: alquileres) {
            inquilinos.add(a.getInquilino());
        }

        return inquilinos;
    }*/
}
