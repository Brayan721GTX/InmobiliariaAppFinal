package com.example.inmobiliaria.modelo;

import net.sourceforge.jtds.jdbc.DateTime;

public class Alquiler {
    private int id;
    private double precio;
    private DateTime fechaInicio;
    private DateTime fechaFin;
    private Inquilino inquilino;
    private Propiedad propiedad;

    public Alquiler(int id, double precio, DateTime fechaInicio, DateTime fechaFin, Inquilino inquilino, Propiedad propiedad) {
        this.id = id;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.inquilino = inquilino;
        this.propiedad = propiedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public DateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(DateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public DateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(DateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }
}
