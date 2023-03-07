package com.VITAPP.Backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class API {
    //Inicio de sesion
    @GetMapping("/Discapacitado_Visual")
    public Discapacitado_VIsual iniciarSesionDisc(@RequestParam String email,@RequestParam String password) throws SQLException, ClassNotFoundException {
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



    @PostMapping("/Discapacitado_Visual_Registro")
    public Discapacitado_VIsual crearRegistroDiscapacitado(@RequestBody Discapacitado_VIsual discapacitado_visual) throws SQLException, ClassNotFoundException {
        DataHanding data = new DataHanding();
        return data.comprobarRegistro(discapacitado_visual);
    }

    @PostMapping("/Jefe_Establecimiento_Registro")
    public Jefe_Establecimiento crearRegistroJefeEstablecimiento(@RequestBody Jefe_Establecimiento jefe_establecimiento) throws SQLException, ClassNotFoundException {
        DataHanding data = new DataHanding();
        return data.comprobarRegistroJefeEstablecimiento(jefe_establecimiento);
    }

}
