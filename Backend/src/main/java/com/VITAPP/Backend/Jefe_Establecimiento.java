package com.VITAPP.Backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.events.Event;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Jefe_Establecimiento extends User{
    private String Direccion;
    private String Ciudad;
    private String Codigo_Postal;
    private String CIF;
    private String Nombre_establecimiento;

    private BufferedImage imagen;

    private String estado;
    public Jefe_Establecimiento() {

    }

    public Jefe_Establecimiento(int ID, String name, String apellido, String password, String email,  String direccion, String ciudad, String codigo_Postal, String CIF, String nombre_establecimiento, String estado, BufferedImage imagen) {
        super(ID, name, apellido, password, email);
        this.Direccion = direccion;
        this.Ciudad = ciudad;
        this.Codigo_Postal = codigo_Postal;
        this.CIF = CIF;
        this.Nombre_establecimiento = nombre_establecimiento;
        this.estado = estado;
        this.imagen = imagen;
    }

    public Jefe_Establecimiento(String json) {
        // Parsear el JSON y asignar los valores a los atributos correspondientes
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Jefe_Establecimiento jefe = objectMapper.readValue(json, Jefe_Establecimiento.class);
            this.CIF = jefe.getCIF();
            this.imagen = jefe.getImagen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        this.Direccion = direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        this.Ciudad = ciudad;
    }

    public String getCodigo_Postal() {
        return Codigo_Postal;
    }

    public void setCodigo_Postal(String codigo_Postal) {
        this.Codigo_Postal = codigo_Postal;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getNombre_establecimiento() {
        return Nombre_establecimiento;
    }

    public void setNombre_establecimiento(String nombre_establecimiento) {
        this.Nombre_establecimiento = nombre_establecimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }


}
