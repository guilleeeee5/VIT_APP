package org.vaadin.example;

import java.sql.Date;

public class Discapacitado_VIsual extends User{
    private String edificio;

    private String calle;

    //private Date fechaentrada;
    private String fechaentrada;

    //private Date fechasalida;
    private String fechasalida;

    public Discapacitado_VIsual(String nombre, String apellido, String contrasena, String email,String edificios, String calle, String fechaentrada, String fechasalida) {
        super( nombre, apellido, contrasena, email);
        this.edificio = edificios;
        this.calle = calle;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
    }

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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getEdificios() {
        return edificio;
    }

    public void setEdificios(String edificios) {
        this.edificio = edificio;
    }

    public String mostrarJson() {
        return "{\n" +
                "\"name\": " + "\"" + getName() + "\"," + "\n" +
                "\"apellido\": " + "\"" + getApellido()  + "\"," + "\n" +
                "\"password\": " + "\"" + getPassword()  + "\"" +  ",\n" +
                "\"email\": "+ "\"" + getEmail() + "\"" + ",\n" +
                "\"fechaentrada\": "+ "\"" + getFechaentrada() + "\"" + ",\n" +
                "\"fechasalida\": "+ "\"" + getFechasalida() + "\"" + "\n" +
                "}";
    }
}
