package com.VITAPP.Backend;

import java.util.Date;

public class Discapacitado_VIsual extends User{
    private String edificio;

    //private Date fechaentrada;
    private String calle;

    private String fechaentrada;
    //private Date fechasalida;
    private String fechasalida;

    public Discapacitado_VIsual(String edificios, String calle, String fechaentrada, String fechasalida) {
        this.edificio = edificios;
        this.calle = calle;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Override
    public String toString() {
        return super.toString() +
                "edificio='" + edificio + '\'' +
                ", fechaentrada='" + fechaentrada + '\'' +
                ", fechasalida='" + fechasalida + '\'' +
                '}';
    }
}
