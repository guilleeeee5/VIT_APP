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
        ResultSet resultSet = statement.executeQuery(String.format("SELECT usuario.name, usuario.apellido, usuario.Email, Discapacitado_Visual.edificio, Discapacitado_Visual.mapa from usuario JOIN Discapacitado_Visual ON usuario.ID = Discapacitado_Visual.ID AND usuario.Email = '%s' AND '%s' = usuario.password", email, password));
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

    public Jefe_Establecimiento comprobarRegistroJefeEstablecimiento(Jefe_Establecimiento jefe_establecimiento) throws ClassNotFoundException, SQLException {
        Jefe_Establecimiento jefe_establecimiento_aux = new Jefe_Establecimiento();
        // Consulta BBDD
        Class.forName("com.mysql.jdbc.Driver");
        // Importante cambiar el puerto para este ejemplo, en este caso comprobar que el CIF y el email del jefe establecimiento estan iguales en la base de datos, ya que un jefe de establecimiento puede tener mas de 1 establecimiento
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://localhost:3306/vit_app_bbdd", "admin", "admin");
        Statement statement = conexionBBDD.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * from jefe_establecimiento JOIN usuario ON usuario.ID = jefe_establecimiento.ID AND usuario.Email = '%s' OR jefe_establecimiento.CIF = '%s'", jefe_establecimiento.getEmail(), jefe_establecimiento.getCIF()));
        if(resultSet.next()){
            return jefe_establecimiento_aux;
        }
        else{
            Statement statement1 = conexionBBDD.createStatement();
            int insertado1 = statement1.executeUpdate(String.format("INSERT INTO usuario (name, apellido, Email, password) VALUES ('%s', '%s', '%s', '%s');", jefe_establecimiento.getName(), jefe_establecimiento_aux.getApellido(), jefe_establecimiento_aux.getEmail(), jefe_establecimiento_aux.getPassword()));
            int insertado2 = statement1.executeUpdate("INSERT INTO jefe_establecimiento (ID) VALUES (LAST_INSERT_ID());");
            return jefe_establecimiento;
        }

    }
}
