package com.VITAPP.Backend;


import java.sql.*;

public class DataHanding {
    public Discapacitado_VIsual comprobarDisc(String email, String password){
        Discapacitado_VIsual discapacitadAUX = new Discapacitado_VIsual();
        //Consulta BBDD
        return discapacitadAUX;
    }
    public Jefe_Establecimiento comprobarJefe(String email, String password) throws ClassNotFoundException, SQLException {
        Jefe_Establecimiento jefeAux = new Jefe_Establecimiento();
        //Consulta BBDD
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://localhost:3307/vit_app_bbdd", "admin", "admin");
        Statement statement = conexionBBDD.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT usuario.name, usuario.apellido, usuario.Email, Jefe_Establecimiento.Direccion, Jefe_Establecimiento.Ciudad, Jefe_Establecimiento.Codigo_Postal, Jefe_Establecimiento.Nombre_Establecimiento from usuario JOIN Jefe_Establecimiento ON usuario.ID = Jefe_Establecimiento.ID AND usuario.Email = '%s' AND '%s' = usuario.password", email, password));
        while (resultSet.next())
        {
            String nombre = resultSet.getString("name");
            String apellido = resultSet.getString("apellido");
            String Email = resultSet.getString("Email");
            String direccion = resultSet.getString("Direccion");
            String ciudad = resultSet.getString("Ciudad");
            String Codigo_Postal = resultSet.getString("Codigo_Postal");
            String Nombre_Establecimiento = resultSet.getString("Nombre_Establecimiento");
            jefeAux.setName(nombre);
            jefeAux.setApellido(apellido);
            jefeAux.setEmail(Email);
            jefeAux.setDireccion(direccion);
            jefeAux.setCiudad(ciudad);
            jefeAux.setCodigo_Postal(Codigo_Postal);
            jefeAux.setNombre_establecimiento(Nombre_Establecimiento);
        }
        return jefeAux;
    }
    public Admin comprobarAdmin(String email, String password) throws ClassNotFoundException, SQLException {
        Admin adminAux = new Admin();
        //Consulta BBDD
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://localhost:3307/vit_app_bbdd", "admin", "admin");
        Statement statement = conexionBBDD.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT usuario.name, usuario.apellido from usuario JOIN admin ON usuario.ID = admin.ID AND usuario.Email = '%s' AND '%s' = usuario.password", email, password));
        while (resultSet.next())
        {
            String nombre = resultSet.getString("name");
            String apellido = resultSet.getString("apellido");
            adminAux.setName(nombre);
            adminAux.setApellido(apellido);
        }
        return adminAux;
    }
}
