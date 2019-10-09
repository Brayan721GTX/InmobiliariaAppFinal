package com.example.inmobiliaria.modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PagoData {

    public ArrayList<Pago> obtenerPagos() {
        return Conexion.pagos;
    }

    public ArrayList<Pago> obtenerPagosDeAlquiler(int idAlquiler) {
        ArrayList<Pago> pagos = new ArrayList<>();

        for (Pago pago: Conexion.pagos) {
            if (pago.getAlquiler().getId() == idAlquiler) {
                pagos.add(pago);
            }
        }

        return pagos;
    }

    public ArrayList<Pago> obtenerPagosDePropiedad(int idPropiedad) {
        ArrayList<Pago> pagos = new ArrayList<>();

        for (Pago pago: Conexion.pagos) {
            if (pago.getAlquiler().getPropiedad().getId() == idPropiedad) {
                pagos.add(pago);
            }
        }

        return pagos;
    }

    /*public ArrayList<Pago> obtenerPagos() {
        try {
            Statement statement = Conexion.getConexion().createStatement();

            String sql = "SELECT * FROM pagos";

            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<Pago> pagos = new ArrayList<Pago>();

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                int nroPago = resultSet.getInt("nro_pago");
                String fecha = resultSet.getString("fecha");
                double importe = resultSet.getDouble("importe");
                int idAlquiler = resultSet.getInt("id_alquiler");

                Alquiler alquiler = new AlquilerData().obtenerContrato(idAlquiler);

                Pago pago = new Pago(id, nroPago, null, importe, alquiler);

                pagos.add(pago);
            }

            return pagos;
        }
        catch (Exception e) {
        }

        return null;
    }

    public ArrayList<Pago> obtenerPagosDeAlquiler(int idAlquiler) {
        try {
            Statement statement = Conexion.getConexion().createStatement();

            String sql = "SELECT * FROM pagos WHERE id_alquiler = "+idAlquiler;

            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<Pago> pagos = new ArrayList<Pago>();

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                int nroPago = resultSet.getInt("nro_pago");
                String fecha = resultSet.getString("fecha");
                double importe = resultSet.getDouble("importe");

                Alquiler alquiler = new AlquilerData().obtenerContrato(idAlquiler);

                Pago pago = new Pago(id, nroPago, null, importe, alquiler);

                pagos.add(pago);
            }

            return pagos;
        }
        catch (Exception e) {
        }

        return null;
    }

    public ArrayList<Pago> obtenerPagosDePropiedad(int idPropiedad) {
        ArrayList<Alquiler> alquileres = new AlquilerData().obtenerContratosDePropiedad(idPropiedad);

        ArrayList<Pago> pagos = new ArrayList<Pago>();

        for (Alquiler a: alquileres) {

            ArrayList<Pago> pagosAux = obtenerPagosDeAlquiler(a.getId());

            for (Pago p: pagosAux) {
                pagos.add(p);
            }
        }

        return pagos;
    }*/
}
