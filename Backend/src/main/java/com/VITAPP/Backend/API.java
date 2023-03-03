package com.VITAPP.Backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
@RestController
public class API {
    //Inicio de sesion
    @GetMapping("/Discapacitado_VIsual/{email}/{password}")
    public Discapacitado_VIsual iniciarSesionDisc(@PathVariable String email, String password){
        DataHanding data = new DataHanding();
        return data.comprobarDisc(email, password);
    }
    @GetMapping("/Jefe_Establecimiento/{email}/{password}")
    public Jefe_Establecimiento iniciarSesionJefe(@PathVariable String email, String password){
        DataHanding data = new DataHanding();
        return data.comprobarJefe(email, password);
    }
    @GetMapping("/Admin/{email}/{password}")
    public Admin iniciarSesionAdmin(@PathVariable String email,@PathVariable String password) throws SQLException, ClassNotFoundException {
        DataHanding data = new DataHanding();
        return data.comprobarAdmin(email, password);
    }
}
