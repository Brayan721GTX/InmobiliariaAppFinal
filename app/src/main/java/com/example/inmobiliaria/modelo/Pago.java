package com.example.inmobiliaria.modelo;

import net.sourceforge.jtds.jdbc.DateTime;

public class Pago {
    private int id;
    private int nroPago;
    private String fecha;
    private double importe;
    private Alquiler alquiler;

    public Pago(int id, int nroPago, String fecha, double importe, Alquiler alquiler) {
        this.id = id;
        this.nroPago = nroPago;
        this.fecha = fecha;
        this.importe = importe;
        this.alquiler = alquiler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNroPago() {
        return nroPago;
    }

    public void setNroPago(int nroPago) {
        this.nroPago = nroPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }
}
