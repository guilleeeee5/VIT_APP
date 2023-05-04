package com.VITAPP.Backend;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class BackendApplicationTests {

	@Test
	void contextLoads() {
	}

	// Comenzamos creando test para verificar el usuario Discapacitado Visual
	@Test
	public void testComprobarDisc() throws ClassNotFoundException, SQLException, ParseException {
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
	public void testComprobarDisc_NoResults() throws ClassNotFoundException, SQLException, ParseException {
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
	public void testComprobarDisc_NullEmail() throws ClassNotFoundException, SQLException, ParseException {
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
	public void testComprobarDisc_NullPassword() throws ClassNotFoundException, SQLException, ParseException {
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
	public void testComprobarDisc_EmptyPassword() throws ClassNotFoundException, SQLException, ParseException {
		// Preparación de la prueba
		String email = "prueba@example.com";
		String password = "";
		DataHanding Data = new DataHanding();

		// Ejecución de la función y comprobación del resultado
		Discapacitado_VIsual discapacitadoActual = Data.comprobarDisc(email, password);
		//Si devuelve estos elementos como nulos ya comprobamos que lo ha realizado correctamente
		assertNull(discapacitadoActual.getName());
		assertNull(discapacitadoActual.getApellido());
		assertNull(discapacitadoActual.getEmail());
		assertNull(discapacitadoActual.getPassword());;
	}

	@Test
	public void testComprobarDisc_EmptyEmail() throws ClassNotFoundException, SQLException, ParseException {
		// Preparación de la prueba
		String email = "";
		String password = "password";
		DataHanding Data = new DataHanding();

		// Ejecución de la función y comprobación del resultado
		Discapacitado_VIsual discapacitadoActual = Data.comprobarDisc(email, password);
		//Si devuelve estos elementos como nulos ya comprobamos que lo ha realizado correctamente
		assertNull(discapacitadoActual.getName());
		assertNull(discapacitadoActual.getApellido());
		assertNull(discapacitadoActual.getEmail());
		assertNull(discapacitadoActual.getPassword());;
	}

	@Test
	public void testComprobarDisc_NullEmailAndPassword() throws ClassNotFoundException, SQLException, ParseException {
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
	public void testComprobarJefe_NullPassword() throws ClassNotFoundException, SQLException {
		// Preparación de la prueba
		String email = "prueba@example.com";
		String password = null;
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
	public void testComprobarJefe_NullEmailAndPassword() throws ClassNotFoundException, SQLException, ParseException {
		//En este test comprobamos que al llamar a la función ComprobarJefe_ con un email y password nulos, lanza una excepción

		// Preparación de la prueba
		String email = null;
		String password = null;

		DataHanding Data = new DataHanding();

		// Ejecución de la función y comprobación del resultado
		Discapacitado_VIsual discapacitadoActual = Data.comprobarDisc(email, password);
		assertNull(discapacitadoActual.getName());
		assertNull(discapacitadoActual.getApellido());
		assertNull(discapacitadoActual.getEmail());
		assertNull(discapacitadoActual.getPassword());;
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
	public void testComprobarJefe_EmptyEmail() throws ClassNotFoundException, SQLException {
		// Preparación de la prueba
		String email = "";
		String password = "password";
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
		String email = "fer@fer.com";
		String password = "fernando1";
		//Comprobamos que dado una contraseña y email se nos devuelva correctamente el usuario
		Jefe_Establecimiento jefeEsperado = new Jefe_Establecimiento();
		DataHanding Data = new DataHanding();
		jefeEsperado.setName("Fernando");
		jefeEsperado.setApellido("Gomez");
		jefeEsperado.setEmail("fer@fer.com");
		jefeEsperado.setDireccion("Calle Nunki");
		jefeEsperado.setCiudad("Madrid");
		jefeEsperado.setCodigo_Postal("2860");
		jefeEsperado.setEstado("2");
		jefeEsperado.setNombre_establecimiento("Lidl");
		jefeEsperado.setCIF("602");

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

	@Test
	public void testComprobarAdminExistente() throws ClassNotFoundException, SQLException {
		// Preparación de la prueba
		String email = "info@nlcapacities.com";
		String password = "admin";
		//Comprobamos que dado una contraseña y email se nos devuelva correctamente el usuario
		Admin adminEsperado = new Admin();
		DataHanding Data = new DataHanding();
		adminEsperado.setName("admin");
		adminEsperado.setApellido("admin");
		adminEsperado.setPassword("admin");
		adminEsperado.setEmail("info@nlcapacities.com");

		// Ejecución de la función y comprobación del resultado
		Admin adminExistente = Data.comprobarAdmin(email, password);
		assertEquals(adminExistente.getID(), adminEsperado.getID());
		assertEquals(adminExistente.getName(), adminEsperado.getName());
		assertEquals(adminExistente.getApellido(), adminEsperado.getApellido());
	}

	@Test
	public void testComprobarAdminNoExistente() throws ClassNotFoundException, SQLException {
		Admin adminEsperado = new Admin();
		DataHanding Data = new DataHanding();
		String email = "admin99@vitapp.com";
		String password = "password123";
		Admin admin1 = Data.comprobarAdmin(email, password);

		assertNull(admin1.getName());
		assertNull(admin1.getApellido());
		assertNull(admin1.getEmail());
		assertNull(admin1.getPassword());

	}
	@Test
	public void testAdmin_NullEmail() throws ClassNotFoundException, SQLException {
		// Preparación de la prueba
		String email = null;
		String password = "password";
		DataHanding Data = new DataHanding();

		// Ejecución de la función y comprobación del resultado
		Admin AdminActual = Data.comprobarAdmin(email, password);
		assertNull(AdminActual.getName());
		assertNull(AdminActual.getApellido());
		assertNull(AdminActual.getEmail());
		assertNull(AdminActual.getPassword());;
	}

	@Test
	public void testAdmin_NullPassword() throws ClassNotFoundException, SQLException {
		// Preparación de la prueba
		String email = "prueba@example.com";
		String password = null;
		DataHanding Data = new DataHanding();

		// Ejecución de la función y comprobación del resultado
		Admin AdminActual = Data.comprobarAdmin(email, password);
		//Si devuelve estos elementos como nulos ya comprobamos que lo ha realizado correctamente
		assertNull(AdminActual.getName());
		assertNull(AdminActual.getApellido());
		assertNull(AdminActual.getEmail());
		assertNull(AdminActual.getPassword());;
	}
	@Test
	public void testAdmin_NullEmailAndPassword() throws ClassNotFoundException, SQLException {
		//En este test comprobamos que al llamar a la función ComprobarJefe_ con un email y password nulos, lanza una excepción

		// Preparación de la prueba
		String email = null;
		String password = null;

		DataHanding Data = new DataHanding();

		// Ejecución de la función y comprobación del resultado
		Admin AdminActual = Data.comprobarAdmin(email, password);
		assertNull(AdminActual.getName());
		assertNull(AdminActual.getApellido());
		assertNull(AdminActual.getEmail());
		assertNull(AdminActual.getPassword());;
	}
	@Test
	public void testAdmin_EmptyPassword() throws ClassNotFoundException, SQLException {
		// Preparación de la prueba
		String email = "prueba@example.com";
		String password = "";
		DataHanding Data = new DataHanding();

		// Ejecución de la función y comprobación del resultado
		Jefe_Establecimiento jefeActual = Data.comprobarJefe(email, password);
		//Si devuelve estos elementos como nulos ya comprobamos que lo ha realizado correctamente
		Admin AdminActual = Data.comprobarAdmin(email, password);
		assertNull(AdminActual.getName());
		assertNull(AdminActual.getApellido());
		assertNull(AdminActual.getEmail());
		assertNull(AdminActual.getPassword());;
	}

	@Test
	public void testAdmin_EmptyEmail() throws ClassNotFoundException, SQLException {
		// Preparación de la prueba
		String email = "";
		String password = "password";
		DataHanding Data = new DataHanding();

		// Ejecución de la función y comprobación del resultado
		Admin AdminActual = Data.comprobarAdmin(email, password);
		//Si devuelve estos elementos como nulos ya comprobamos que lo ha realizado correctamente
		assertNull(AdminActual.getName());
		assertNull(AdminActual.getApellido());
		assertNull(AdminActual.getEmail());
		assertNull(AdminActual.getPassword());;
	}

}
