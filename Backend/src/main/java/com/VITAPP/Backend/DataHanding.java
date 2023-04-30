package com.VITAPP.Backend;


import javax.xml.transform.Result;
import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;

public class DataHanding {
    public Discapacitado_VIsual comprobarDisc(String email, String password) throws ClassNotFoundException, SQLException {
        Discapacitado_VIsual discapacitadAUX = new Discapacitado_VIsual();
        //Consulta BBDD
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://nlcapacities.com:7002/nlcapacities", "dom-nlcapacities", "rg48Q59Rt7-97");
        Statement statement = conexionBBDD.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT usuario.name, usuario.apellido, usuario.Email, discapacitado_visual.edificio, discapacitado_visual.mapa from usuario JOIN discapacitado_visual ON usuario.ID = discapacitado_visual.ID AND usuario.Email = '%s' AND '%s' = usuario.password", email, password));
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
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://nlcapacities.com:7002/nlcapacities", "dom-nlcapacities", "rg48Q59Rt7-97");
        Statement statement = conexionBBDD.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT usuario.name, usuario.apellido, usuario.Email, jefe_establecimiento.Direccion, jefe_establecimiento.Ciudad, jefe_establecimiento.Codigo_Postal, jefe_establecimiento.Nombre_Establecimiento, jefe_establecimiento.estado, jefe_establecimiento.CIF from usuario JOIN jefe_establecimiento ON usuario.ID = jefe_establecimiento.ID AND usuario.Email = '%s' AND '%s' = usuario.password", email, password));
        while (resultSet.next())
        {
            String nombre = resultSet.getString("name");
            String apellido = resultSet.getString("apellido");
            String Email = resultSet.getString("Email");
            String direccion = resultSet.getString("Direccion");
            String ciudad = resultSet.getString("Ciudad");
            String Codigo_Postal = resultSet.getString("Codigo_Postal");
            String Nombre_Establecimiento = resultSet.getString("Nombre_Establecimiento");
            String estado = resultSet.getString("estado");
            String cif = resultSet.getString("CIF");
            jefeAux.setName(nombre);
            jefeAux.setApellido(apellido);
            jefeAux.setEmail(Email);
            jefeAux.setDireccion(direccion);
            jefeAux.setCiudad(ciudad);
            jefeAux.setCodigo_Postal(Codigo_Postal);
            jefeAux.setNombre_establecimiento(Nombre_Establecimiento);
            jefeAux.setEstado(estado);
            jefeAux.setCIF(cif);
        }
        conexionBBDD.close();
        return jefeAux;
    }
    public Admin comprobarAdmin(String email, String password) throws ClassNotFoundException, SQLException {
        Admin adminAux = new Admin();
        //Consulta BBDD
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://nlcapacities.com:7002/nlcapacities", "dom-nlcapacities", "rg48Q59Rt7-97");;
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
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://nlcapacities.com:7002/nlcapacities", "dom-nlcapacities", "rg48Q59Rt7-97");
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
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://nlcapacities.com:7002/nlcapacities", "dom-nlcapacities", "rg48Q59Rt7-97");
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

    public void eliminarJefe(String cif) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://nlcapacities.com:7002/nlcapacities", "dom-nlcapacities", "rg48Q59Rt7-97");
        Statement statement = conexionBBDD.createStatement();
        int rowsAffected = statement.executeUpdate(String.format("DELETE FROM jefe_establecimiento WHERE CIF = '%s'", cif));
    }

    public ArrayList<Jefe_Establecimiento> modificarJefe(Jefe_Establecimiento jefeAntiguo, Jefe_Establecimiento jefeNuevo) throws ClassNotFoundException, SQLException {
        ArrayList<Jefe_Establecimiento> jefes = new ArrayList<Jefe_Establecimiento>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://nlcapacities.com:7002/nlcapacities", "dom-nlcapacities", "rg48Q59Rt7-97");

            // Si la actualización fue exitosa, actualizar la tabla usuario
            PreparedStatement statement = conexionBBDD.prepareStatement("UPDATE usuario JOIN jefe_establecimiento ON (usuario.ID = jefe_establecimiento.ID) SET name = ?, apellido = ?, password = ?, Email = ?, estado = ?, Direccion = ?, Ciudad = ?, Codigo_Postal = ?, Nombre_Establecimiento = ? WHERE CIF = ?");
            statement.setString(1, jefeNuevo.getName());
            statement.setString(2, jefeNuevo.getApellido());
            statement.setString(3, jefeNuevo.getPassword());
            statement.setString(4, jefeNuevo.getEmail());
            statement.setString(5, jefeNuevo.getEstado());
            statement.setString(6, jefeNuevo.getDireccion());
            statement.setString(7, jefeNuevo.getCiudad());
            statement.setString(8, jefeNuevo.getCodigo_Postal());
            statement.setString(9, jefeNuevo.getNombre_establecimiento());
            statement.setString(10, jefeNuevo.getCIF());
            statement.executeUpdate();

            // Obtener la lista actualizada de jefes
            ResultSet resultSet = statement.executeQuery("SELECT * from jefe_establecimiento JOIN usuario ON usuario.ID = jefe_establecimiento.ID");
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
                jefeAux.setEstado(resultSet.getString("estado"));
                jefes.add(jefeAux);
            }
        return jefes;
    }



    public ArrayList<Jefe_Establecimiento> devolverEstablecimientos() throws SQLException, ClassNotFoundException {
        ArrayList<Jefe_Establecimiento> listaEstablecimientos = new ArrayList<Jefe_Establecimiento>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://nlcapacities.com:7002/nlcapacities", "dom-nlcapacities", "rg48Q59Rt7-97");

        String sql = "SELECT * from jefe_establecimiento JOIN usuario ON usuario.ID = jefe_establecimiento.ID";

        Statement statement = conexionBBDD.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int count = 0;
        while (result.next()){
            Jefe_Establecimiento jefeAux = new Jefe_Establecimiento();
            jefeAux.setCiudad(result.getString("Ciudad"));
            jefeAux.setName(result.getString("name"));
            jefeAux.setPassword(result.getString("password"));
            jefeAux.setApellido(result.getString("apellido"));
            jefeAux.setCIF(result.getString("CIF"));
            jefeAux.setEmail(result.getString("Email"));
            jefeAux.setCodigo_Postal(result.getString("Codigo_Postal"));
            jefeAux.setDireccion(result.getString("Direccion"));
            jefeAux.setID(result.getInt("ID"));
            jefeAux.setNombre_establecimiento(result.getString("Nombre_Establecimiento"));
            jefeAux.setEstado(result.getString("estado"));
            listaEstablecimientos.add(jefeAux);
        }

        return listaEstablecimientos;
    }

    public void guardarImagen(String imagen, String cif) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://nlcapacities.com:7002/nlcapacities", "dom-nlcapacities", "rg48Q59Rt7-97");
        byte[] imagenBytes = Base64.getDecoder().decode(imagen);
        String sql = String.format("UPDATE jefe_establecimiento SET imagen = ? WHERE CIF = '%s'", cif);

        PreparedStatement ps = conexionBBDD.prepareStatement(sql);
        ps.setBytes(1, imagenBytes);
        ps.executeUpdate();

        String sql2 = String.format("UPDATE jefe_establecimiento SET estado = 2 WHERE CIF = '%s'", cif);
        PreparedStatement ps2 = conexionBBDD.prepareStatement(sql2);
        int result1 = ps2.executeUpdate();
    }

    public byte[] obtenerImagen(String cif) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://nlcapacities.com:7002/nlcapacities", "dom-nlcapacities", "rg48Q59Rt7-97");
        String sql = String.format("SELECT imagen FROM jefe_establecimiento WHERE cif = %s;", (cif));

        Statement statement = conexionBBDD.createStatement();
        ResultSet result = statement.executeQuery(sql);

        byte[] imagenBytes = new byte[0];
        while (result.next()) {
            Blob imagenBlob = result.getBlob("imagen");
            imagenBytes = imagenBlob.getBytes(1, (int) imagenBlob.length());
        }

        return imagenBytes;
    }

    public ArrayList<Discapacitado_VIsual> sitiosvisitados() throws ClassNotFoundException, SQLException {
        ArrayList<Discapacitado_VIsual> lista = new ArrayList<Discapacitado_VIsual>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexionBBDD = DriverManager.getConnection("jdbc:mysql://nlcapacities.com:7002/nlcapacities", "dom-nlcapacities", "rg48Q59Rt7-97");
        String sql = "SELECT Nombre, Email, Apellido, edificio FROM discapacitado_visual";
        Statement statement = conexionBBDD.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int count = 0;
        while (result.next()) {
            Discapacitado_VIsual discapacitadoVIsual = new Discapacitado_VIsual();
            String nombre = result.getString("Nombre");
            String email = result.getString("Email");
            String apellido = result.getString("Apellido");
            String edificio = result.getString("edificio");
            discapacitadoVIsual.setName(nombre);
            discapacitadoVIsual.setEmail(email);
            discapacitadoVIsual.setApellido(apellido);
            discapacitadoVIsual.setEdificio(edificio);
            lista.add(discapacitadoVIsual);
        }
        return lista;
    }


}
