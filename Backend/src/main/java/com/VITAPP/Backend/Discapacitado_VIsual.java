package com.VITAPP.Backend;

import java.util.Date;

public class Discapacitado_VIsual extends User{
    private String edificio;

    //private Date fechaentrada;
    private String fechaentrada;
    //private Date fechasalida;
    private String fechasalida;

    public Discapacitado_VIsual(int ID, String name, String apellido, String password, String Email,  String edificio, String fechaentrada, String fechasalida) {
        super(ID, name, apellido, password, Email);
        this.edificio = edificio;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
    }

    public Discapacitado_VIsual() {
    }

    public String getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(String fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public String getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getEdificios() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return super.toString() +
                "edificio='" + edificio  +
                ", fechaentrada=" + fechaentrada +
                ", fechasalida=" + fechasalida +
                '}';
    }
}
