package com.VITAPP.Backend;

import org.junit.Test;

import static org.junit.Assert.*;
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
    // Comenzamos los test del usuario Jefe de establecimiento

}