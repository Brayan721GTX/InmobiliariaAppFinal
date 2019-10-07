package com.example.inmobiliaria.modelo;

import android.content.ContentValues;

import java.sql.ResultSet;
import java.sql.Statement;

public class PropietarioData {

    public Propietario credencialesValidas(String email, String password) {
        try {
            Statement statement = Conexion.getConexion().createStatement();

            String sql = "SELECT * FROM propietario WHERE email = "+email+" password = "+password;

            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                String dni = resultSet.getString("dni");
                String apellido = resultSet.getString("apellido");
                String nombre = resultSet.getString("nombre");
                String telefono = resultSet.getString("telefono");
                String mail = resultSet.getString("mail");
                String pass = resultSet.getString("password");

                Propietario propietario = new Propietario(id, dni, apellido, nombre, telefono, mail, pass);

                return propietario;
            }
        }
        catch (Exception e) {
        }

        return null;
    }

    public Propietario obtenerPropietarioPorId(int idPropietario) {
        try {
            Statement statement = Conexion.getConexion().createStatement();

            String sql = "SELECT * FROM propietario WHERE id = "+idPropietario;

            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                String dni = resultSet.getString("dni");
                String apellido = resultSet.getString("apellido");
                String nombre = resultSet.getString("nombre");
                String telefono = resultSet.getString("telefono");
                String mail = resultSet.getString("mail");
                String pass = resultSet.getString("password");

                Propietario propietario = new Propietario(id, dni, apellido, nombre, telefono, mail, pass);

                return propietario;
            }
        }
        catch (Exception e) {
        }

        return null;
    }

    public Propietario obtenerPropietarioPorDni(String dni) {
        try {
            Statement statement = Conexion.getConexion().createStatement();

            String sql = "SELECT * FROM propietario WHERE dni = "+dni;

            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                String apellido = resultSet.getString("apellido");
                String nombre = resultSet.getString("nombre");
                String telefono = resultSet.getString("telefono");
                String mail = resultSet.getString("mail");
                String pass = resultSet.getString("password");

                Propietario propietario = new Propietario(id, dni, apellido, nombre, telefono, mail, pass);

                return propietario;
            }
        }
        catch (Exception e) {
        }

        return null;
    }

    public void editarPropietario(Propietario p) {
        try {
            Statement statement = Conexion.getConexion().createStatement();

            String sql = "UPDATE propietario SET dni='"+p.getDni()+"', apellido='"+p.getApellido()
                    +"', nombre='"+p.getNombre()+"', telefono='"+p.getTelefono()+"', mail='"+p.getMail()
                    +"', password='"+p.getPassword()+"' WHERE id = "+p.getId();

            statement.executeUpdate(sql);
        }
        catch (Exception e) {
        }
    }
}
