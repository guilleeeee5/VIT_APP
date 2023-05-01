package org.vaadin.example;

import java.sql.Date;

public class Discapacitado_VIsual extends User{
    private String edificio;
    private int mapa;

    //private Date fechaentrada;
    private String fechaentrada;

    //private Date fechasalida;
    private String fechasalida;

    public Discapacitado_VIsual(String name, String apellido, String password, String email, int ID, String edificios, int mapa, String fechaentrada, String fechasalida) {
        super(name, apellido, password, email, ID);
        this.edificio = edificios;
        this.mapa = mapa;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
    }

    public Discapacitado_VIsual() {
    }

    public Discapacitado_VIsual(String nombre, String apellido, String contrasena, String correo) {
        super(nombre, apellido, contrasena, correo);
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

    public void setEdificios(String edificios) {
        this.edificio = edificio;
    }

    public int getMapa() {
        return mapa;
    }

    public void setMapa(int mapa) {
        this.mapa = mapa;
    }

    public String mostrarJson() {
        return "{\n" +
                "\"name\": " + "\"" + getName() + "\"," + "\n" +
                "\"apellido\": " + "\"" + getApellido()  + "\"," + "\n" +
                "\"password\": " + "\"" + getPassword()  + "\"" +  ",\n" +
                "\"email\": "+ "\"" + getEmail() + "\"" + "\n" +
                "\"fechaentrada\": "+ "\"" + getFechaentrada() + "\"" + "\n" +
                "\"fechasalida\": "+ "\"" + getFechasalida() + "\"" + "\n" +
                "}";
    }
}
