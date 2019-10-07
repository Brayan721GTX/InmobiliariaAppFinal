package com.example.inmobiliaria.modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PropiedadData {

    public ArrayList<Propiedad> obtenerPropiedades(int idPropietario) {
        try {
            Statement statement = Conexion.getConexion().createStatement();

            String sql = "SELECT * FROM inmueble WHERE id_propietario = "+idPropietario;

            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<Propiedad> propiedades = new ArrayList<Propiedad>();

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String direccion = resultSet.getString("direccion");
                int ambientes = resultSet.getInt("ambientes");
                String tipo = resultSet.getString("tipo");
                String uso = resultSet.getString("uso");
                double precio = resultSet.getDouble("precio");
                int dis = resultSet.getInt("disponible");
                boolean disponible = (dis > 0)?true:false;
                Propietario propietario = new PropietarioData().obtenerPropietarioPorId(idPropietario);

                Propiedad propiedad = new Propiedad(id, direccion, ambientes, tipo, uso, precio, disponible, propietario);

                return propiedades;
            }
        }
        catch (Exception e) {
        }

        return null;
    }

    public Propiedad obtenerPropiedadPorId(int idPropiedad) {
        try {
            Statement statement = Conexion.getConexion().createStatement();

            String sql = "SELECT * FROM inmueble WHERE id = "+idPropiedad;

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String direccion = resultSet.getString("direccion");
                int ambientes = resultSet.getInt("ambientes");
                String tipo = resultSet.getString("tipo");
                String uso = resultSet.getString("uso");
                double precio = resultSet.getDouble("precio");
                int dis = resultSet.getInt("disponible");
                boolean disponible = (dis > 0)?true:false;
                int idPropietario = resultSet.getInt("id_propietario");
                Propietario propietario = new PropietarioData().obtenerPropietarioPorId(idPropietario);

                Propiedad propiedad = new Propiedad(id, direccion, ambientes, tipo, uso, precio, disponible, propietario);

                return propiedad;
            }
        }
        catch (Exception e) {
        }

        return null;
    }

    public void editarPropiedad(int idPropiedad, boolean estado) {
        try {
            Statement statement = Conexion.getConexion().createStatement();

            int disponible = (estado)?1:0;

            String sql = "UPDATE inmueble SET disponible = "+disponible+" WHERE id = "+idPropiedad;

            statement.executeUpdate(sql);
        }
        catch (Exception e) {
        }
    }
}
