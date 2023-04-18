package com.VITAPP.Backend;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;

public class DataHandingTest
{
    // Comenzamos creando test para verificar el usuario Discapacitado Visual
    @Test
    public void testComprobarDisc() throws ClassNotFoundException, SQLException
    {
        //En este test comprobamos que al llamar a la funcion Comprobar Discapacitado ese usuario no existe
        //Y la funcion devuelve un usuario que no se corresponde al insertado
        // Preparación de la prueba
        String email = "prueba@example.com";
        String password = "password";

        Discapacitado_VIsual discapacitadoEsperado = new Discapacitado_VIsual();
        DataHanding Data = new DataHanding();
        discapacitadoEsperado.setName("Juan");
        discapacitadoEsperado.setApellido("Pérez");
        discapacitadoEsperado.setEmail("prueba@example.com");
        discapacitadoEsperado.setEdificio("Edificio A");

        // Ejecución de la función y comprobación del resultado
        Discapacitado_VIsual discapacitadoActual = Data.comprobarDisc(email, password);
        assertNotEquals(discapacitadoEsperado, discapacitadoActual);
    }

    // Prueba de la función comprobarDisc cuando la consulta no devuelve resultados.
    @Test
    public void testComprobarDisc_NoResults() throws ClassNotFoundException, SQLException {
        // Preparación de la prueba
        String email = "prueba@example.com";
        String password = "password";
        DataHanding Data = new DataHanding();

        // Ejecución de la función y comprobación del resultado
        Discapacitado_VIsual discapacitadoActual = Data.comprobarDisc(email, password);
        assertNull(discapacitadoActual.getName());
        assertNull(discapacitadoActual.getApellido());
        assertNull(discapacitadoActual.getEmail());
        assertNull(discapacitadoActual.getEdificios());
    }

    // Prueba de la función comprobarDisc cuando se proporciona una dirección de correo electrónico nula.
    @Test
    public void testComprobarDisc_NullEmail() throws ClassNotFoundException, SQLException {
        // Preparación de la prueba
        String email = null;
        String password = "password";
        DataHanding Data = new DataHanding();

        // Ejecución de la función y comprobación del resultado
        Discapacitado_VIsual discapacitadoActual = Data.comprobarDisc(email, password);
        assertNull(discapacitadoActual.getName());
        assertNull(discapacitadoActual.getApellido());
        assertNull(discapacitadoActual.getEmail());
        assertNull(discapacitadoActual.getEdificios());
    }

    @Test
    public void testComprobarDisc_NullPassword() throws ClassNotFoundException, SQLException {
        //En este test comprobamos que al llamar a la función Comprobar Discapacitado con un password nulo, lanza una excepción

        // Preparación de la prueba
        String email = "prueba@example.com";
        String password = null;
        DataHanding Data = new DataHanding();

        // Ejecución de la función y comprobación del resultado
        Discapacitado_VIsual discapacitadoActual = Data.comprobarDisc(email, password);
        assertNull(discapacitadoActual.getName());
        assertNull(discapacitadoActual.getApellido());
        assertNull(discapacitadoActual.getEmail());
        assertNull(discapacitadoActual.getEdificios());
    }

    @Test
    public void testComprobarDisc_NullEmailAndPassword() throws ClassNotFoundException, SQLException {
        //En este test comprobamos que al llamar a la función Comprobar Discapacitado con un email y password nulos, lanza una excepción

        // Preparación de la prueba
        String email = null;
        String password = null;

        DataHanding Data = new DataHanding();

        // Ejecución de la función y comprobación del resultado
        Discapacitado_VIsual discapacitadoActual = Data.comprobarDisc(email, password);
        assertNull(discapacitadoActual.getName());
        assertNull(discapacitadoActual.getApellido());
        assertNull(discapacitadoActual.getEmail());
        assertNull(discapacitadoActual.getEdificios());
    }
    // Comenzamos los test del usuario Jefe de establecimiento
    @Test
    public void testComprobarJefe_NullEmail() throws ClassNotFoundException, SQLException {
        // Preparación de la prueba
        String email = null;
        String password = "password";
        DataHanding Data = new DataHanding();

        // Ejecución de la función y comprobación del resultado
        Jefe_Establecimiento jefeActual = Data.comprobarJefe(email, password);
        assertNull(jefeActual.getName());
        assertNull(jefeActual.getApellido());
        assertNull(jefeActual.getEmail());
        assertNull(jefeActual.getPassword());;
    }

    @Test
    public void testComprobarJefe_EmptyPassword() throws ClassNotFoundException, SQLException {
        // Preparación de la prueba
        String email = "prueba@example.com";
        String password = "";
        DataHanding Data = new DataHanding();

        // Ejecución de la función y comprobación del resultado
        Jefe_Establecimiento jefeActual = Data.comprobarJefe(email, password);
        //Si devuelve estos elementos como nulos ya comprobamos que lo ha realizado correctamente
        assertNull(jefeActual.getName());
        assertNull(jefeActual.getApellido());
        assertNull(jefeActual.getEmail());
        assertNull(jefeActual.getPassword());;
    }
    @Test
    public void testComprobarJefe_NoResults() throws ClassNotFoundException, SQLException {
        DataHanding Data = new DataHanding();
        Jefe_Establecimiento jefeVacio = new Jefe_Establecimiento(0, null, null, null, null, null, null, null, null, null, null, null);
        Jefe_Establecimiento jefeActual = Data.comprobarJefe("jefe@example.com", "password");
        //Debemos comprobar atributo a atributo si ha devuelto un objeto nulo
        //Esto es debido a que un assert Null no comprueba elemento a elemento si es nulo
        assertEquals(jefeVacio.getID(), jefeActual.getID());
        assertEquals(jefeVacio.getName(), jefeActual.getName());
        assertEquals(jefeVacio.getApellido(), jefeActual.getApellido());
        assertEquals(jefeVacio.getPassword(), jefeActual.getPassword());
        assertEquals(jefeVacio.getEmail(), jefeActual.getEmail());
        assertEquals(jefeVacio.getDireccion(), jefeActual.getDireccion());
        assertEquals(jefeVacio.getCiudad(), jefeActual.getCiudad());
        assertEquals(jefeVacio.getCodigo_Postal(), jefeActual.getCodigo_Postal());
        assertEquals(jefeVacio.getCIF(), jefeActual.getCIF());
        assertEquals(jefeVacio.getNombre_establecimiento(), jefeActual.getNombre_establecimiento());
        assertEquals(jefeVacio.getEstado(), jefeActual.getEstado());
        assertEquals(jefeVacio.getImagen(), jefeActual.getImagen());
    }

    @Test
    public void testComprobarJefe() throws ClassNotFoundException, SQLException {
        // Preparación de la prueba
        String email = "guille@guille.com";
        String password = "guille";
        //Comprobamos que dado una contraseña y email se nos devuelva correctamente el usuario
        Jefe_Establecimiento jefeEsperado = new Jefe_Establecimiento();
        DataHanding Data = new DataHanding();
        jefeEsperado.setName("guille");
        jefeEsperado.setApellido("ramirez");
        jefeEsperado.setEmail("guille@guille.com");
        jefeEsperado.setDireccion("calle guille, 33");
        jefeEsperado.setCiudad("nanocity");
        jefeEsperado.setCodigo_Postal("33");
        jefeEsperado.setEstado("");
        jefeEsperado.setNombre_establecimiento("aston martin");

        // Ejecución de la función y comprobación del resultado
        Jefe_Establecimiento jefeActual = Data.comprobarJefe(email, password);
        assertEquals(jefeEsperado.getID(), jefeActual.getID());
        assertEquals(jefeEsperado.getName(), jefeActual.getName());
        assertEquals(jefeEsperado.getApellido(), jefeActual.getApellido());
        assertEquals(jefeEsperado.getPassword(), jefeActual.getPassword());
        assertEquals(jefeEsperado.getEmail(), jefeActual.getEmail());
        assertEquals(jefeEsperado.getDireccion(), jefeActual.getDireccion());
        assertEquals(jefeEsperado.getCiudad(), jefeActual.getCiudad());
        assertEquals(jefeEsperado.getCodigo_Postal(), jefeActual.getCodigo_Postal());
        assertEquals(jefeEsperado.getCIF(), jefeActual.getCIF());
        assertEquals(jefeEsperado.getNombre_establecimiento(), jefeActual.getNombre_establecimiento());
        assertEquals(jefeEsperado.getEstado(), jefeActual.getEstado());
        assertEquals(jefeEsperado.getImagen(), jefeActual.getImagen());
    }
}