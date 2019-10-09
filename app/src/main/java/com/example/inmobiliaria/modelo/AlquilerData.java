package com.example.inmobiliaria.modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AlquilerData {

    public ArrayList<Alquiler> obtenerContratosDePropiedad(int idPropiedad) {
        ArrayList<Alquiler> alquileres = new ArrayList<Alquiler>();

        for (Alquiler a: Conexion.alquileres) {
            if (a.getPropiedad().getId() == idPropiedad) {
                alquileres.add(a);
            }
        }

        return alquileres;
    }

    public Alquiler obtenerContrato(int idAlquiler) {
        for (Alquiler a : Conexion.alquileres) {
            if (a.getId() == idAlquiler) {
                return a;
            }
        }

        return null;
    }

    /*public ArrayList<Alquiler> obtenerContratosDePropiedad(int idPropiedad) {
        try {
            Statement statement = Conexion.getConexion().createStatement();

            String sql = "SELECT * FROM alquiler WHERE id_inmueble = "+idPropiedad;

            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<Alquiler> alquileres = new ArrayList<Alquiler>();

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                double precio = resultSet.getDouble("precio");
                String fechaInicio = resultSet.getString("fecha_inicio");
                String fechaFin = resultSet.getString("fecha_fin");
                String idInquilino = resultSet.getString("id_inquilino");
                Inquilino i = new InquilinoData().obtenerInquilino(id);
                Propiedad p = new PropiedadData().obtenerPropiedadPorId(idPropiedad);

                Alquiler alquiler = new Alquiler(id, precio, null, null, i, p);

                alquileres.add(alquiler);

                return alquileres;
            }
        }
        catch (Exception e) {
        }

        return null;
    }

    public Alquiler obtenerContrato(int idAlquiler) {
        try {
            Statement statement = Conexion.getConexion().createStatement();

            String sql = "SELECT * FROM alquiler WHERE id = "+idAlquiler;

            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                double precio = resultSet.getDouble("precio");
                String fechaInicio = resultSet.getString("fecha_inicio");
                String fechaFin = resultSet.getString("fecha_fin");
                String idInquilino = resultSet.getString("id_inquilino");
                String idPropiedad = resultSet.getString("id_inmueble");
                Inquilino i = new InquilinoData().obtenerInquilino(id);
                Propiedad p = new PropiedadData().obtenerPropiedadPorId(Integer.parseInt(idPropiedad));

                Alquiler alquiler = new Alquiler(id, precio, null, null, i, p);

                return alquiler;
            }
        }
        catch (Exception e) {
        }

        return null;
    }*/

}
