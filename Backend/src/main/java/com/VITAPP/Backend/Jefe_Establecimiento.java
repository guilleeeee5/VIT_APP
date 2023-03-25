package com.VITAPP.Backend;

import org.yaml.snakeyaml.events.Event;

public class Jefe_Establecimiento extends User{
    private String Direccion;
    private String Ciudad;
    private String Codigo_Postal;
    private String CIF;
    private String Nombre_establecimiento;

    private String estado;
    public Jefe_Establecimiento() {

    }

    public Jefe_Establecimiento(int ID, String name, String apellido, String password, String email,  String direccion, String ciudad, String codigo_Postal, String CIF, String nombre_establecimiento, String estado) {
        super(ID, name, apellido, password, email);
        this.Direccion = direccion;
        this.Ciudad = ciudad;
        this.Codigo_Postal = codigo_Postal;
        this.CIF = CIF;
        this.Nombre_establecimiento = nombre_establecimiento;
        this.estado = estado;
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
}
