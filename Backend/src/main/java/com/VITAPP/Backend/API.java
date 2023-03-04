package com.VITAPP.Backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
@RestController
public class API {
    //Inicio de sesion
    @GetMapping("/Discapacitado_Visual")
    public Discapacitado_VIsual iniciarSesionDisc(@RequestParam String email,@RequestParam String password){
        DataHanding data = new DataHanding();
        return data.comprobarDisc(email, password);
    }
    @GetMapping("/Jefe_Establecimiento")
    public Jefe_Establecimiento iniciarSesionJefe(@RequestParam String email,@RequestParam String password) throws SQLException, ClassNotFoundException {
        DataHanding data = new DataHanding();
        return data.comprobarJefe(email, password);
    }
    @GetMapping("/Admin")
    public Admin iniciarSesionAdmin(@RequestParam String email,@RequestParam String password) throws SQLException, ClassNotFoundException {
        DataHanding data = new DataHanding();
        return data.comprobarAdmin(email, password);
    }
}
