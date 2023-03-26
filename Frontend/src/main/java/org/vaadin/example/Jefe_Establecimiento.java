package org.vaadin.example;

public class Jefe_Establecimiento extends User{
    private String direccion;
    private String ciudad;
    private String codigo_Postal;
    private String cif;
    private String nombre_establecimiento;

    private String estado;
    public Jefe_Establecimiento() {

    }

    

    public Jefe_Establecimiento(int ID, String name, String apellido, String password, String email, String direccion, String ciudad, String codigo_Postal, String cif, String nombre_establecimiento, String estado) {
        super( name, apellido, password, email, ID);
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codigo_Postal = codigo_Postal;
        this.cif = cif;
        this.nombre_establecimiento = nombre_establecimiento;
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigo_Postal() {
        return codigo_Postal;
    }

    public void setCodigo_Postal(String codigo_Postal) {
        this.codigo_Postal = codigo_Postal;
    }

    public String getNombre_establecimiento() {
        return nombre_establecimiento;
    }

    public void setNombre_establecimiento(String nombre_establecimiento) {
        this.nombre_establecimiento = nombre_establecimiento;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String mostrarJson() {
        return "{\n" +
                "\"name\": " + "\"" + getName() + "\"," + "\n" +
                "\"apellido\": " + "\"" + getApellido()  + "\"," + "\n" +
                "\"password\": " + "\"" + getPassword() + "\""  +  ",\n" +
                "\"email\": " + "\"" + getEmail() + "\"" +",\n" +
                "\"direccion\": " + "\"" + getDireccion() + "\"" + ",\n" +
                "\"ciudad\": " + "\"" + getCiudad() + "\"" + ",\n" +
                "\"codigo_Postal\": " + "\"" + getCodigo_Postal() + "\"" + ",\n" +
                "\"cif\": " + "\"" + getCif() + "\"" + ",\n" +
                "\"nombre_establecimiento\": " + "\"" + getNombre_establecimiento() + "\"" + ",\n" +
                "\"estado\": " + "\"" + getEstado() + "\"" + "\n" +
                "}";
    }
}
