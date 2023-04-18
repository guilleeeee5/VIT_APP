package com.VITAPP.Backend;

import org.junit.Test;

import static org.junit.Assert.*;
import java.sql.SQLException;

public class DataHandingTest
{
    @Test
    public void testComprobarDisc() throws ClassNotFoundException, SQLException
    {
        //En este test comprobamos que al llamar a la funcion Comprobar Discapacitado ese usuario no existe
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

    @Test(expected=SQLException.class)
    public void testComprobarDisc_SQLException() throws ClassNotFoundException, SQLException {
        // Preparación de la prueba
        String email = "prueba@example.com";
        String password = "password";
        DataHanding Data = new DataHanding();
        // Ejecución de la función y comprobación del resultado
        Discapacitado_VIsual discapacitadoActual = Data.comprobarDisc(email, password);
    }

    @Test(expected=ClassNotFoundException.class)
    public void testComprobarDisc_ClassNotFoundException() throws ClassNotFoundException, SQLException {
        // Preparación de la prueba
        String email = "prueba@example.com";
        String password = "password";
        DataHanding Data = new DataHanding();
        // Ejecución de la función y comprobación del resultado
        Discapacitado_VIsual discapacitadoActual = Data.comprobarDisc(email, password);
    }

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
}