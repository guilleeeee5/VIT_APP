package com.VITAPP.Backend;
import com.mysql.management.*;

import java.sql.*;

public class DataHanding {
    public Discapacitado_VIsual comprobarDisc(String email, String password){
        //Consulta BBDD
        Discapacitado_VIsual discapacitadAUX = new Discapacitado_VIsual();
        return discapacitadAUX;
    }
    public Jefe_Establecimiento comprobarJefe(String email, String password){
        Jefe_Establecimiento jefeAux = new Jefe_Establecimiento();
        //Consulta BBDD
        return jefeAux;
    }
    public Admin comprobarAdmin(String email, String password) throws ClassNotFoundException, SQLException {
        Admin adminAux = new Admin();
        //Consulta BBDD
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://localhost:80/vit_app_bbdd", "admin", "admin");
        Statement statement = conexionBBDD.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT usuario.name, usuario.apellido from usuario JOIN admin" +
                "ON usuario.ID = admin.ID" +
                "AND usuario.Email = '%s' AND '%s' = usuario.password", email, password));
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
