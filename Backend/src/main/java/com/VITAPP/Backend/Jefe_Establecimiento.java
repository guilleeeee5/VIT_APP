package com.VITAPP.Backend;

public class Jefe_Establecimiento extends User{
    private String Calle;
    private String Numero;
    private String Ciudad;
    private String Codigo_Postal;
    private String CIF;
    public Jefe_Establecimiento() {

    }

    public Jefe_Establecimiento(String name, String apellido, String password, String email, String calle, String numero, String ciudad, String codigo_Postal, String CIF) {
        super(name, apellido, password, email);
        Calle = calle;
        Numero = numero;
        Ciudad = ciudad;
        Codigo_Postal = codigo_Postal;
        this.CIF = CIF;
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
}
