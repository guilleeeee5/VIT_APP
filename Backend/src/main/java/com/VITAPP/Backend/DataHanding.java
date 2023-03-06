package com.VITAPP.Backend;


import javax.xml.transform.Result;
import java.sql.*;

public class DataHanding {
    public Discapacitado_VIsual comprobarDisc(String email, String password) throws ClassNotFoundException, SQLException {
        Discapacitado_VIsual discapacitadAUX = new Discapacitado_VIsual();
        //Consulta BBDD
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://localhost:3307/vit_app_bbdd", "admin", "admin");
        Statement statement = conexionBBDD.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT usuario.name, usuario.apellido, usuario.Email, discapacitado_visual.edificio, Discapacitado_Visual.mapa from usuario JOIN discapacitado_visual ON usuario.ID = discapacitado_visual.ID AND usuario.Email = '%s' AND '%s' = usuario.password", email, password));
        while (resultSet.next())
        {
            String nombre = resultSet.getString("name");
            String apellido = resultSet.getString("apellido");
            String Email = resultSet.getString("Email");
            String edificio = resultSet.getString("edificio");
            //String mapa = resultSet.
            discapacitadAUX.setName(nombre);
            discapacitadAUX.setApellido(apellido);
            discapacitadAUX.setEmail(Email);
            discapacitadAUX.setEdificio(edificio);
            //discapacitadAUX.setMapa(mapa);
        }
        return discapacitadAUX;
    }
    public Jefe_Establecimiento comprobarJefe(String email, String password) throws ClassNotFoundException, SQLException {
        Jefe_Establecimiento jefeAux = new Jefe_Establecimiento();
        //Consulta BBDD
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://localhost:3307/vit_app_bbdd", "admin", "admin");
        Statement statement = conexionBBDD.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT usuario.name, usuario.apellido, usuario.Email, jefe_establecimiento.Direccion, jefe_establecimiento.Ciudad, jefe_establecimiento.Codigo_Postal, jefe_establecimiento.Nombre_Establecimiento from usuario JOIN jefe_establecimiento ON usuario.ID = jefe_establecimiento.ID AND usuario.Email = '%s' AND '%s' = usuario.password", email, password));
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

    public Discapacitado_VIsual comprobarRegistro(Discapacitado_VIsual discapacitado_vIsual) throws ClassNotFoundException, SQLException {
        Discapacitado_VIsual discapacitado_vIsualaux = new Discapacitado_VIsual();
        // Consulta BBDD
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://localhost:3307/vit_app_bbdd", "admin", "admin");
        Statement statement = conexionBBDD.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * from discapacitado_visual JOIN usuario ON usuario.ID = discapacitado_visual.ID AND usuario.Email = '%s'", discapacitado_vIsual.getEmail()));
        if(resultSet.next()){
            return discapacitado_vIsualaux;
        }
        else{
            Statement statement1 = conexionBBDD.createStatement();
            int insertado1 = statement1.executeUpdate(String.format("INSERT INTO usuario (name, apellido, Email, password) VALUES ('%s', '%s', '%s', '%s');", discapacitado_vIsual.getName(), discapacitado_vIsual.getApellido(), discapacitado_vIsual.getEmail(), discapacitado_vIsual.getPassword()));
            int insertado2 = statement1.executeUpdate("INSERT INTO discapacitado_visual (ID) VALUES (LAST_INSERT_ID());");
            return discapacitado_vIsual;
        }

    }
}
