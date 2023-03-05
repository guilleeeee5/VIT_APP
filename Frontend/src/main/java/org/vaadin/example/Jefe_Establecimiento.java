package org.vaadin.example;

import org.yaml.snakeyaml.events.Event;

public class Jefe_Establecimiento extends User{
    private String Calle;
    private String Numero;
    private String Ciudad;
    private String Codigo_Postal;
    private String CIF;
    private String Nombre_establecimiento;
    public Jefe_Establecimiento() {

    }

    public Jefe_Establecimiento(String name, String apellido, String password, String email, int ID, String calle, String numero, String ciudad, String codigo_Postal, String CIF) {
        super(name, apellido, password, email, ID);
        Calle = calle;
        Numero = numero;
        Ciudad = ciudad;
        Codigo_Postal = codigo_Postal;
        this.CIF = CIF;
        Nombre_establecimiento = Nombre_establecimiento;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String calle) {
        Calle = calle;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getCodigo_Postal() {
        return Codigo_Postal;
    }

    public void setCodigo_Postal(String codigo_Postal) {
        Codigo_Postal = codigo_Postal;
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
        Nombre_establecimiento = nombre_establecimiento;
    }
    public String mostrarJson() {
        return "{\n" +
                "\"name\": " + "\"" + getName() + "\"," + "\n" +
                "\"apellido\": " + "\"" + getApellido()  + "\"," + "\n" +
                "\"password\": " + getPassword()  +  ",\n" +
                "\"email\": " + getEmail() + ",\n" +
                "\"Numero\": " + getNumero() + ",\n" +
                "\"codigo_Postal\": " + getCodigo_Postal() + ",\n" +
                "\"CIF\": " + getCIF() + ",\n" +
                "\"Nombre_establecimiento\": " + getNombre_establecimiento() + ",\n" +
                "}";
    }
}
