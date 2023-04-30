package com.VITAPP.Backend;

import java.util.Date;

public class Discapacitado_VIsual extends User{
    private String edificio;
    private int mapa;

    private Date fechaentrada;
    private Date fechasalida;

    public Discapacitado_VIsual(int ID, String name, String apellido, String password, String Email,  String edificio, int mapa, Date fechaentrada, Date fechasalida) {
        super(ID, name, apellido, password, Email);
        this.edificio = edificio;
        this.mapa = mapa;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
    }

    public Discapacitado_VIsual() {
    }

    public Date getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(Date fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getEdificios() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public int getMapa() {
        return mapa;
    }

    public void setMapa(int mapa) {
        this.mapa = mapa;
    }

    @Override
    public String toString() {
        return super.toString() +
                "edificio='" + edificio  +
                ", mapa=" + mapa +
                ", fechaentrada=" + fechaentrada +
                ", fechasalida=" + fechasalida +
                '}';
    }
}
