package com.VITAPP.Backend;


import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

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
        conexionBBDD.close();
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
        conexionBBDD.close();
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
        conexionBBDD.close();
        return adminAux;
    }

    public Discapacitado_VIsual comprobarRegistro(Discapacitado_VIsual discapacitado_vIsual) throws ClassNotFoundException, SQLException {
        Discapacitado_VIsual discapacitado_vIsualaux = new Discapacitado_VIsual();
        // Consulta BBDD
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://localhost:3307/vit_app_bbdd", "admin", "admin");
        Statement statement = conexionBBDD.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * from discapacitado_visual JOIN usuario ON usuario.ID = discapacitado_visual.ID AND usuario.Email = '%s'", discapacitado_vIsual.getEmail()));
        if(!resultSet.next()){
            conexionBBDD.close();
            return discapacitado_vIsualaux;
        }
        else{
            Statement statement1 = conexionBBDD.createStatement();
            int insertado1 = statement1.executeUpdate(String.format("INSERT INTO usuario (name, apellido, Email, password) VALUES ('%s', '%s', '%s', '%s');", discapacitado_vIsual.getName(), discapacitado_vIsual.getApellido(), discapacitado_vIsual.getEmail(), discapacitado_vIsual.getPassword()));
            int insertado2 = statement1.executeUpdate("INSERT INTO discapacitado_visual (ID) VALUES (LAST_INSERT_ID());");
            conexionBBDD.close();
            return discapacitado_vIsual;
        }

    }

    public Jefe_Establecimiento comprobarRegistroJefeEstablecimiento(Jefe_Establecimiento jefe_establecimiento) throws ClassNotFoundException, SQLException {
        Jefe_Establecimiento jefe_establecimiento_aux = new Jefe_Establecimiento();
        // Consulta BBDD
        Class.forName("com.mysql.jdbc.Driver");
        // Importante cambiar el puerto para este ejemplo, en este caso comprobar que el CIF y el email del jefe establecimiento estan iguales en la base de datos, ya que un jefe de establecimiento puede tener mas de 1 establecimiento
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://localhost:3307/vit_app_bbdd", "admin", "admin");
        Statement statement = conexionBBDD.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * from jefe_establecimiento JOIN usuario ON usuario.ID = jefe_establecimiento.ID AND (usuario.Email = '%s' OR jefe_establecimiento.CIF = '%s');", jefe_establecimiento.getEmail(), jefe_establecimiento.getCIF()));
        if(resultSet.next()){
            conexionBBDD.close();
            return jefe_establecimiento_aux;
        }
        else{
            Statement statement1 = conexionBBDD.createStatement();
            int insertado1 = statement1.executeUpdate(String.format("INSERT INTO usuario (name, apellido, Email, password) VALUES ('%s', '%s', '%s', '%s');", jefe_establecimiento.getName(), jefe_establecimiento.getApellido(), jefe_establecimiento.getEmail(), jefe_establecimiento.getPassword()));
            int insertado2 = statement1.executeUpdate(String.format("INSERT INTO jefe_establecimiento (ID, Direccion, Ciudad, Codigo_Postal, Nombre_Establecimiento, CIF) VALUES (LAST_INSERT_ID(), '%s', '%s', '%s', '%s', '%s');", jefe_establecimiento.getDireccion(), jefe_establecimiento.getCiudad(), jefe_establecimiento.getCodigo_Postal(), jefe_establecimiento.getNombre_establecimiento(), jefe_establecimiento.getCIF()));
            conexionBBDD.close();
            return jefe_establecimiento;
        }

    }

    public ArrayList<Jefe_Establecimiento> eliminarJefe(Jefe_Establecimiento jefe) throws ClassNotFoundException, SQLException {
        ArrayList<Jefe_Establecimiento> jefes = new ArrayList<Jefe_Establecimiento>();
        //Consulta BBDD DELETE FROM jefe_establecimiento
        //WHERE CIF = 'valor_CIF';
        Class.forName("com.mysql.jdbc.Driver");
        // Importante cambiar el puerto para este ejemplo, en este caso comprobar que el CIF y el email del jefe establecimiento estan iguales en la base de datos, ya que un jefe de establecimiento puede tener mas de 1 establecimiento
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://localhost:3307/vit_app_bbdd", "admin", "admin");
        Statement statement = conexionBBDD.createStatement();
        int rowsAffected = statement.executeUpdate(String.format("DELETE FROM jefe_establecimiento WHERE CIF = '%s'", jefe.getCIF()));
        ResultSet resultSet1 = statement.executeQuery(String.format("SELECT * from jefe_establecimiento JOIN usuario ON usuario.ID = jefe_establecimiento.ID"));
        // Recorrer los resultados del ResultSet y crear objetos Jefe_Establecimiento
        while (resultSet1.next()) {
            Jefe_Establecimiento jefeAux = new Jefe_Establecimiento();
            // Establecer las propiedades del objeto a partir de los valores del ResultSet
            jefeAux.setName(resultSet1.getString("name"));
            jefeAux.setApellido(resultSet1.getString("apellido"));
            jefeAux.setPassword(resultSet1.getString("password"));
            jefeAux.setEmail(resultSet1.getString("Email"));
            jefeAux.setDireccion(resultSet1.getString("Direccion"));
            jefeAux.setCiudad(resultSet1.getString("Ciudad"));
            jefeAux.setCodigo_Postal(resultSet1.getString("Codigo_Postal"));
            jefeAux.setCIF(resultSet1.getString("CIF"));
            jefeAux.setNombre_establecimiento(resultSet1.getString("Nombre_Establecimiento"));

            // Agregar el objeto Jefe_Establecimiento al ArrayList
            jefes.add(jefeAux);
        }


        return jefes;
    }

    public ArrayList<Jefe_Establecimiento> modificarJefe(Jefe_Establecimiento jefeAntiguo, Jefe_Establecimiento jefeNuevo) throws ClassNotFoundException, SQLException {
        ArrayList<Jefe_Establecimiento> jefes = new ArrayList<Jefe_Establecimiento>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://localhost:3307/vit_app_bbdd", "admin", "admin");
        PreparedStatement statement = conexionBBDD.prepareStatement("UPDATE jefe_establecimiento SET Direccion = ?, Ciudad = ?, Codigo_Postal = ?, Nombre_Establecimiento = ? WHERE CIF = ?");
        statement.setString(1, jefeNuevo.getDireccion());
        statement.setString(2, jefeNuevo.getCiudad());
        statement.setString(3, jefeNuevo.getCodigo_Postal());
        statement.setString(4, jefeNuevo.getNombre_establecimiento());
        statement.setString(5, jefeAntiguo.getCIF());
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            PreparedStatement statement2 = conexionBBDD.prepareStatement("UPDATE usuario SET name = ?, apellido = ?, password = ?, Email = ? WHERE CIF = ?");
            statement2.setString(1, jefeNuevo.getName());
            statement2.setString(2, jefeNuevo.getApellido());
            statement2.setString(3, jefeNuevo.getPassword());
            statement2.setString(4, jefeNuevo.getEmail());
            statement2.setString(5, jefeAntiguo.getCIF());
            statement2.executeUpdate();
            ResultSet resultSet = statement.executeQuery("SELECT * from jefe_establecimiento");
            while (resultSet.next()) {
                Jefe_Establecimiento jefeAux = new Jefe_Establecimiento();
                jefeAux.setName(resultSet.getString("name"));
                jefeAux.setApellido(resultSet.getString("apellido"));
                jefeAux.setPassword(resultSet.getString("password"));
                jefeAux.setEmail(resultSet.getString("Email"));
                jefeAux.setDireccion(resultSet.getString("Direccion"));
                jefeAux.setCiudad(resultSet.getString("Ciudad"));
                jefeAux.setCodigo_Postal(resultSet.getString("Codigo_Postal"));
                jefeAux.setCIF(resultSet.getString("CIF"));
                jefeAux.setNombre_establecimiento(resultSet.getString("Nombre_Establecimiento"));
                jefes.add(jefeAux);
            }
        }
        return jefes;
    }


    public ArrayList<Jefe_Establecimiento> devolverEstablecimientos() throws SQLException, ClassNotFoundException {
        ArrayList<Jefe_Establecimiento> listaEstablecimientos = new ArrayList<Jefe_Establecimiento>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://localhost:3307/vit_app_bbdd", "admin", "admin");

        String sql = "SELECT * from jefe_establecimiento JOIN usuario ON usuario.ID = jefe_establecimiento.ID";

        Statement statement = conexionBBDD.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int count = 0;
        while (result.next()){
            Jefe_Establecimiento jefeAux = new Jefe_Establecimiento();
            jefeAux.setCiudad(result.getString("Ciudad"));
            jefeAux.setName(result.getString("name"));
            jefeAux.setApellido(result.getString("apellido"));
            jefeAux.setCIF(result.getString("CIF"));
            jefeAux.setEmail(result.getString("Email"));
            jefeAux.setCodigo_Postal(result.getString("Codigo_Postal"));
            jefeAux.setDireccion(result.getString("Direccion"));
            jefeAux.setID(Integer.parseInt(result.getString("ID")));
            jefeAux.setNombre_establecimiento(result.getString("Nombre_Establecimiento"));
            jefeAux.setEstado(result.getString("estado"));
            listaEstablecimientos.add(jefeAux);
        }

        return listaEstablecimientos;
    }
}
